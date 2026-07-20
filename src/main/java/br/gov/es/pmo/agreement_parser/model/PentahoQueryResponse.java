package br.gov.es.pmo.agreement_parser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collections;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PentahoQueryResponse {

    private List<List<Object>> resultset;

    public List<List<Object>> getResultset() {
        return resultset == null ? Collections.emptyList() : resultset;
    }

    public void setResultset(List<List<Object>> resultset) {
        this.resultset = resultset;
    }
}
