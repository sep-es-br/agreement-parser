package br.gov.es.pmo.agreement_parser.config;

import br.gov.es.pmo.agreement_parser.properties.PentahoAgreementProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("br.gov.es.pmo.agreement_parser")
@EnableConfigurationProperties(PentahoAgreementProperties.class)
public class AgreementParserAutoConfig {
}
