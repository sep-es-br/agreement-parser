package br.gov.es.pmo.agreement_parser.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "pentaho-bi")
public class PentahoAgreementProperties {

    private String baseUrl;
    private String userId;
    private String password;
    private String cooperationYearsPath;
    private String cooperationYearsDataAccessId;
    private String cooperationOrganizationsPath;
    private String cooperationOrganizationsDataAccessId;
    private String cooperationProcessesPath;
    private String cooperationProcessesDataAccessId;
    private String cooperationAgreementPath;
    private String cooperationAgreementDataAccessId;
    private String contractYearsPath;
    private String contractYearsDataAccessId;
    private String contractOrganizationsPath;
    private String contractOrganizationsDataAccessId;
    private String contractProcessesPath;
    private String contractProcessesDataAccessId;
    private String contractAgreementPath;
    private String contractAgreementDataAccessId;

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
    public String getCooperationAgreementPath() { return cooperationAgreementPath; }
    public void setCooperationAgreementPath(String value) { this.cooperationAgreementPath = value; }
    public String getCooperationAgreementDataAccessId() { return cooperationAgreementDataAccessId; }
    public void setCooperationAgreementDataAccessId(String value) { this.cooperationAgreementDataAccessId = value; }
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
    public String getContractAgreementPath() { return contractAgreementPath; }
    public void setContractAgreementPath(String value) { this.contractAgreementPath = value; }
    public String getContractAgreementDataAccessId() { return contractAgreementDataAccessId; }
    public void setContractAgreementDataAccessId(String value) { this.contractAgreementDataAccessId = value; }
}
