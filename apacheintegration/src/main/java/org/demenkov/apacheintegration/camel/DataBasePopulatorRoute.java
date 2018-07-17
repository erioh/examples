package org.demenkov.apacheintegration.camel;

import org.apache.camel.builder.RouteBuilder;
import org.demenkov.apacheintegration.camel.bean.BeanLogger;
import org.demenkov.apacheintegration.camel.bean.ReportEntityExtractor;
import org.springframework.stereotype.Component;

@Component
public class DataBasePopulatorRoute extends RouteBuilder {


    @Override
    public void configure() {
        from("file://resources/input/?delete=false")
                .process("logProcessor")
                .process("xmlConverterProcessor")
                .process("logProcessor")
                .bean(ReportEntityExtractor.class, "extract")
                .bean(BeanLogger.class, "log")
//                .to("jpa:org.demenkov.apacheintegration.dao.entity.ReportEntity")
                .to("mybatis:insertReportEntity?statementType=Insert")
                .log("Object is inserted");
    }
}