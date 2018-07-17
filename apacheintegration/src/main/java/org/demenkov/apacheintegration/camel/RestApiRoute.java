package org.demenkov.apacheintegration.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.demenkov.apacheintegration.service.impl.ReportEntityServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class RestApiRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .contextPath("/camel")
                .bindingMode(RestBindingMode.json);
        ;

        rest("/test").description("Books REST service")
                .get("/")
                .route().routeId("test-id")
                .bean(ReportEntityServiceImpl.class, "findAll")
                .log("${body}")
                .endRest()
        ;

    }
}
