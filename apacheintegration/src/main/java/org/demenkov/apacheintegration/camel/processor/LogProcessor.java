package org.demenkov.apacheintegration.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Service;

@Service
public class LogProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getBody().toString());
    }
}
