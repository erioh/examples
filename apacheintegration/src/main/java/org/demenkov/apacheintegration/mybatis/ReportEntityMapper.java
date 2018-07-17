package org.demenkov.apacheintegration.mybatis;

import org.demenkov.apacheintegration.dao.entity.ReportEntity;

import java.util.List;

public interface ReportEntityMapper {
    ReportEntity selectReportEntity(int id);

    List<ReportEntity> selectAll();

    List<ReportEntity> selectBySuccess(String success);

    void insertReportEntity(ReportEntity reportEntity);
}
