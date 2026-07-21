package br.gov.es.pmo.agreement_parser.service;

import br.gov.es.pmo.agreement_core.model.AgreementDto;
import br.gov.es.pmo.agreement_core.model.AgreementOrganizationDto;
import br.gov.es.pmo.agreement_core.model.AgreementType;
import br.gov.es.pmo.agreement_core.model.IAgreementProvider;
import br.gov.es.pmo.agreement_parser.model.PentahoQueryResponse;
import br.gov.es.pmo.agreement_parser.properties.PentahoAgreementProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PentahoAgreementProvider implements IAgreementProvider {

    private static final String CDA_ENDPOINT = "/pentaho/plugin/cda/api/doQuery";

    private final PentahoAgreementProperties properties;
    private final Environment environment;
    private final WebClient webClient;

    public PentahoAgreementProvider(
        PentahoAgreementProperties properties,
        Environment environment
    ) {
        this.properties = properties;
        this.environment = environment;
        this.webClient = WebClient.builder().baseUrl(properties.getBaseUrl()).build();
    }

    @Override
    public List<Long> getYears(AgreementType type) {
        PentahoQueryResponse response = query(
            yearsPath(type),
            yearsDataAccessId(type),
            null,
            null
        );

        return response.getResultset().stream()
            .map(row -> Long.valueOf(value(row, 0)))
            .collect(Collectors.toList());
    }

    @Override
    public List<AgreementOrganizationDto> getOrganizations(
        AgreementType type,
        Long year
    ) {
        PentahoQueryResponse response = query(
            organizationsPath(type),
            organizationsDataAccessId(type),
            "paramp_ano",
            String.valueOf(year)
        );

        return response.getResultset().stream()
            .map(row -> toOrganization(type, row))
            .collect(Collectors.toList());
    }

    @Override
    public List<AgreementDto> getAgreements(
        AgreementType type,
        Long year,
        AgreementOrganizationDto organization
    ) {
        String organizationParameter = type == AgreementType.CONTRACT
            ? "paramp_orgao"
            : "paramp_cod_ug";

        PentahoQueryResponse response = queryProcesses(
            processesPath(type),
            processesDataAccessId(type),
            year,
            organizationParameter,
            organization.getIdentifier()
        );

        return response.getResultset().stream()
            .map(row -> toAgreement(type, year, organization, row))
            .collect(Collectors.toList());
    }

    private PentahoQueryResponse query(
        String path,
        String dataAccessId,
        String parameterName,
        String parameterValue
    ) {
        validateCredentials();

        return webClient.get()
            .uri(builder -> {
                builder.path(CDA_ENDPOINT)
                    .queryParam("path", path)
                    .queryParam("dataAccessId", dataAccessId);
                if (parameterName != null) {
                    builder.queryParam(parameterName, parameterValue);
                }
                return builder.build();
            })
            .headers(this::setBasicAuth)
            .retrieve()
            .bodyToMono(PentahoQueryResponse.class)
            .block();
    }

    private PentahoQueryResponse queryProcesses(
        String path,
        String dataAccessId,
        Long year,
        String organizationParameter,
        String organizationIdentifier
    ) {
        validateCredentials();

        return webClient.get()
            .uri(builder -> builder.path(CDA_ENDPOINT)
                .queryParam("path", path)
                .queryParam("dataAccessId", dataAccessId)
                .queryParam("paramp_ano", year)
                .queryParam(organizationParameter, organizationIdentifier)
                .build())
            .headers(this::setBasicAuth)
            .retrieve()
            .bodyToMono(PentahoQueryResponse.class)
            .block();
    }

    private AgreementOrganizationDto toOrganization(
        AgreementType type,
        List<Object> row
    ) {
        if (type == AgreementType.CONTRACT) {
            String name = value(row, 0);
            return new AgreementOrganizationDto(name, name);
        }
        return new AgreementOrganizationDto(value(row, 0), value(row, 1));
    }

    private AgreementDto toAgreement(
        AgreementType type,
        Long year,
        AgreementOrganizationDto organization,
        List<Object> row
    ) {
        AgreementDto dto = new AgreementDto();
        dto.setType(type);
        dto.setYear(year);
        dto.setProcessId(toLong(value(row, 0)));
        dto.setObject(value(row, 1));
        dto.setProcessNumber(value(row, 2));
        dto.setProtocol(value(row, 2));

        if (type == AgreementType.CONTRACT) {
            dto.setOrganizationName(organization.getName());
        } else {
            dto.setManagementUnitId(toLong(organization.getIdentifier()));
            dto.setManagementUnitName(organization.getName());
        }

        dto.setPartyName(value(row, 3));
        dto.setPartyCnpj(value(row, 4));

        return dto;
    }

    private void validateCredentials() {
        if (!StringUtils.hasText(userId())
            || !StringUtils.hasText(password())) {
            throw new IllegalStateException("Credenciais do Pentaho não configuradas");
        }
    }

    private void setBasicAuth(HttpHeaders headers) {
        headers.setBasicAuth(userId(), password());
    }

    private String userId() {
        return StringUtils.hasText(properties.getUserId())
            ? properties.getUserId()
            : environment.getProperty("pentahoBI.userId");
    }

    private String password() {
        return StringUtils.hasText(properties.getPassword())
            ? properties.getPassword()
            : environment.getProperty("pentahoBI.password");
    }

    private static String value(List<Object> row, int index) {
        Object value = row.get(index);
        return value == null ? null : String.valueOf(value);
    }

    private static Long toLong(String value) {
        try {
            return value == null ? null : Long.valueOf(value);
        } catch (NumberFormatException ignored) {
            return null;
        }
    }

    private String yearsPath(AgreementType type) {
        return type == AgreementType.CONTRACT
            ? properties.getContractYearsPath()
            : properties.getCooperationYearsPath();
    }

    private String yearsDataAccessId(AgreementType type) {
        return type == AgreementType.CONTRACT
            ? properties.getContractYearsDataAccessId()
            : properties.getCooperationYearsDataAccessId();
    }

    private String organizationsPath(AgreementType type) {
        return type == AgreementType.CONTRACT
            ? properties.getContractOrganizationsPath()
            : properties.getCooperationOrganizationsPath();
    }

    private String organizationsDataAccessId(AgreementType type) {
        return type == AgreementType.CONTRACT
            ? properties.getContractOrganizationsDataAccessId()
            : properties.getCooperationOrganizationsDataAccessId();
    }

    private String processesPath(AgreementType type) {
        return type == AgreementType.CONTRACT
            ? properties.getContractProcessesPath()
            : properties.getCooperationProcessesPath();
    }

    private String processesDataAccessId(AgreementType type) {
        return type == AgreementType.CONTRACT
            ? properties.getContractProcessesDataAccessId()
            : properties.getCooperationProcessesDataAccessId();
    }
}
