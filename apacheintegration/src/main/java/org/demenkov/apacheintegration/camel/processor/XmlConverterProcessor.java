package org.demenkov.apacheintegration.camel.processor;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.demenkov.apacheintegration.dao.entity.ReportEntity;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;

@Service
public class XmlConverterProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        JAXBContext context = JAXBContext.newInstance(ReportEntity.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ReportEntity newBody = (ReportEntity) unmarshaller.unmarshal(new ByteArrayInputStream(body.getBytes()));
        System.out.println(newBody);
        exchange.getIn().setBody(newBody);
    }
}
