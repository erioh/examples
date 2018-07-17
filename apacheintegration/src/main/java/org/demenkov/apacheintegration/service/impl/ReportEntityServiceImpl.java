package org.demenkov.apacheintegration.service.impl;

import org.demenkov.apacheintegration.dao.ReportEntityDao;
import org.demenkov.apacheintegration.dao.entity.ReportEntity;
import org.demenkov.apacheintegration.service.ReportEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportEntityServiceImpl implements ReportEntityService {
    @Autowired
    ReportEntityDao reportEntityDao;

    @Override
    public List<ReportEntity> findAll() {
        return reportEntityDao.findAll();
    }

    @Override
    public List<ReportEntity> findBySuccess(String success) {
        return reportEntityDao.findBySuccess(success);
    }
}
