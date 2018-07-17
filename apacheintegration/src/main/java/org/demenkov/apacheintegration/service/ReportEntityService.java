package org.demenkov.apacheintegration.service;

import org.demenkov.apacheintegration.dao.entity.ReportEntity;

import java.util.List;

public interface ReportEntityService {
    List<ReportEntity> findAll();
    List<ReportEntity> findBySuccess(String success);
}
