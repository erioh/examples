package org.demenkov.apacheintegration.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.demenkov.apacheintegration.dao.entity.ReportEntity;

import java.util.List;

public interface ReportEntityDao {
    List<ReportEntity> findAll();

    @Results({
            @Result(id = true, property = "id", column = "person_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name")
    }
    )
    List<ReportEntity> findBySuccess(String success);

    void insertReportEntity(ReportEntity reportEntity);
}
