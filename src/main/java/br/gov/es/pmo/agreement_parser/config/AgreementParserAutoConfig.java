package br.gov.es.pmo.agreement_parser.config;

import br.gov.es.pmo.agreement_parser.properties.PentahoAgreementProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("br.gov.es.pmo.agreement_parser")
@EnableConfigurationProperties(PentahoAgreementProperties.class)
@PropertySource("classpath:agreement-parser.properties")
public class AgreementParserAutoConfig {
}
