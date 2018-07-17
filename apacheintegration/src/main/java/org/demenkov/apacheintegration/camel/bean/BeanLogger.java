package org.demenkov.apacheintegration.camel.bean;

import org.demenkov.apacheintegration.dao.entity.ReportEntity;
import org.springframework.stereotype.Service;

@Service
public class BeanLogger {
    public ReportEntity log(ReportEntity entity) {
        System.out.println(entity);
        return entity;
    }
}
