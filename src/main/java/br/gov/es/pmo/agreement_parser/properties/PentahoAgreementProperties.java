package br.gov.es.pmo.agreement_parser.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pentaho-bi")
public class PentahoAgreementProperties {

    private String baseUrl = "https://bi.sep.es.gov.br";
    private String userId;
    private String password;
    private String cooperationYearsPath =
        "/public/dashboard/pmo/dados_abertos/dados_abertos_conv_ano.cda";
    private String cooperationYearsDataAccessId =
        "dados_abertos_conv_ano";
    private String cooperationOrganizationsPath =
        "/public/dashboard/pmo/dados_abertos/dados_abertos_conv_orgao.cda";
    private String cooperationOrganizationsDataAccessId =
        "dados_abertos_conv_orgao";
    private String cooperationProcessesPath =
        "/public/dashboard/pmo/dados_abertos/dados_abertos_conv_processos.cda";
    private String cooperationProcessesDataAccessId =
        "dados_abertos_conv_processos";
    private String contractYearsPath =
        "/public/dashboard/pmo/dados_abertos/dados_abertos_contr_ano.cda";
    private String contractYearsDataAccessId =
        "dados_abertos_contr_ano";
    private String contractOrganizationsPath =
        "/public/dashboard/pmo/dados_abertos/dados_abertos_contr_orgao.cda";
    private String contractOrganizationsDataAccessId =
        "dados_abertos_contr_orgao";
    private String contractProcessesPath =
        "/public/dashboard/pmo/dados_abertos/dados_abertos_contr_processos.cda";
    private String contractProcessesDataAccessId =
        "dados_abertos_contr_processos";

    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getCooperationYearsPath() { return cooperationYearsPath; }
    public void setCooperationYearsPath(String value) { this.cooperationYearsPath = value; }
    public String getCooperationYearsDataAccessId() { return cooperationYearsDataAccessId; }
    public void setCooperationYearsDataAccessId(String value) { this.cooperationYearsDataAccessId = value; }
    public String getCooperationOrganizationsPath() { return cooperationOrganizationsPath; }
    public void setCooperationOrganizationsPath(String value) { this.cooperationOrganizationsPath = value; }
    public String getCooperationOrganizationsDataAccessId() { return cooperationOrganizationsDataAccessId; }
    public void setCooperationOrganizationsDataAccessId(String value) { this.cooperationOrganizationsDataAccessId = value; }
    public String getCooperationProcessesPath() { return cooperationProcessesPath; }
    public void setCooperationProcessesPath(String value) { this.cooperationProcessesPath = value; }
    public String getCooperationProcessesDataAccessId() { return cooperationProcessesDataAccessId; }
    public void setCooperationProcessesDataAccessId(String value) { this.cooperationProcessesDataAccessId = value; }
    public String getContractYearsPath() { return contractYearsPath; }
    public void setContractYearsPath(String value) { this.contractYearsPath = value; }
    public String getContractYearsDataAccessId() { return contractYearsDataAccessId; }
    public void setContractYearsDataAccessId(String value) { this.contractYearsDataAccessId = value; }
    public String getContractOrganizationsPath() { return contractOrganizationsPath; }
    public void setContractOrganizationsPath(String value) { this.contractOrganizationsPath = value; }
    public String getContractOrganizationsDataAccessId() { return contractOrganizationsDataAccessId; }
    public void setContractOrganizationsDataAccessId(String value) { this.contractOrganizationsDataAccessId = value; }
    public String getContractProcessesPath() { return contractProcessesPath; }
    public void setContractProcessesPath(String value) { this.contractProcessesPath = value; }
    public String getContractProcessesDataAccessId() { return contractProcessesDataAccessId; }
    public void setContractProcessesDataAccessId(String value) { this.contractProcessesDataAccessId = value; }
}
