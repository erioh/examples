package org.demenkov.apacheintegration.config;

import org.apache.camel.component.mybatis.MyBatisComponent;
import org.apache.ibatis.session.SqlSessionFactory;
import org.demenkov.apacheintegration.dao.impl.DefaultReportEntityDao;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
public class MyBatisConfig {
    @Autowired
    DataSource dataSource;
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource resource = new ClassPathResource("SqlMapConfig.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate getSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public DefaultReportEntityDao getDefaultReportEntityDao(SqlSessionFactory sqlSessionFactory) {
        DefaultReportEntityDao defaultReportEntityDao = new DefaultReportEntityDao();
        defaultReportEntityDao.setSqlSessionFactory(sqlSessionFactory);
        return defaultReportEntityDao;
    }

    @Bean(name = "mybatis")
    public MyBatisComponent myBatisComponent(SqlSessionFactory sqlSessionFactory) {
        MyBatisComponent result = new MyBatisComponent();
        result.setSqlSessionFactory(sqlSessionFactory);
        return result;
    }
}
