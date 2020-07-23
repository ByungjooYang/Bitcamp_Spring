package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import member.bean.MemberDTO;

@Configuration
public class SpringConfiguration {
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##java");
		dataSource.setPassword("bit");
		dataSource.setMaxTotal(20);
		dataSource.setMaxIdle(3);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(resolver.getResource("classpath:spring/mybatis-config.xml"));

		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:*/dao/*Mapper.xml"));
		return sqlSessionFactoryBean.getObject();
			
	}
	
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());		
	}
	
	
	@Bean
	public DataSourceTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}

	
	@Bean 
	public MemberDTO userDTO() { 
		return new MemberDTO(); 
	}
}
