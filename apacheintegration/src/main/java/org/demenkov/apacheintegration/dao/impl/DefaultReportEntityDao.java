package org.demenkov.apacheintegration.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.demenkov.apacheintegration.dao.ReportEntityDao;
import org.demenkov.apacheintegration.dao.entity.ReportEntity;
import org.demenkov.apacheintegration.mybatis.ReportEntityMapper;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class DefaultReportEntityDao extends SqlSessionDaoSupport implements ReportEntityDao {
    @Override
    public List<ReportEntity> findAll() {
        SqlSession sqlSession = getSqlSession();
        return getSqlSession().getMapper(ReportEntityMapper.class).selectAll();
    }

    @Override
    public List<ReportEntity> findBySuccess(String success) {
        return getSqlSession().getMapper(ReportEntityMapper.class).selectBySuccess(success);
    }

    @Override
    public void insertReportEntity(ReportEntity reportEntity){
        getSqlSession().getMapper(ReportEntityMapper.class).insertReportEntity(reportEntity);
    }
}
