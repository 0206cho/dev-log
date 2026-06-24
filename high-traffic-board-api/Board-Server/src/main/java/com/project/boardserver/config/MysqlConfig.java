package com.project.boardserver.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * description    : MyBatis와 MySQL 데이터베이스를 연동
 * packageName    : com.project.boardserver.config
 * fileName        : MysqlConfig
 * author         : kimminsol
 * date           : 2026. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 2.        kimminsol       최초 생성
 */
@Configuration
@MapperScan(basePackages = "com.project.boardserver.mapper")
public class MysqlConfig {
    /**
     * SqlSessionFactory Bean을 생성
     * @param dataSource
     * @return
     * @throws Exception
     */
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 실제 SQL 쿼리문이 작성되어 있는 XML 매퍼 파일들의 위치를 설정 - src/main/resources/mapper/ 폴더 안의 모든 .xml 파일
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));

        // MyBatis의 전반적인 세부 설정
        // src/main/resources/mybatis-config.xml 파일을 찾아 리소스로 가져옴
        Resource mybatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
        sessionFactory.setConfigLocation(mybatisConfig);

        return sessionFactory.getObject();
    }
}
