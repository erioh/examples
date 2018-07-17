package org.demenkov.apacheintegration.camel.bean;

import org.apache.camel.Exchange;
import org.demenkov.apacheintegration.dao.entity.ReportEntity;
import org.springframework.stereotype.Service;

@Service
public class ReportEntityExtractor {
    public ReportEntity extract(Exchange exchange) {
        return  (ReportEntity) exchange.getIn().getBody();
    }
}
