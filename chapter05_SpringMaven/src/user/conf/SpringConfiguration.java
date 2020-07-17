package user.conf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import user.bean.UserDTO;
import user.dao.UserDAO;
import user.dao.UserDAOMyBatis;
import user.main.HelloSpring;
import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSelectService;
import user.service.UserUpdateService;

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
		sqlSessionFactoryBean.setConfigLocation(resolver.getResource("spring/mybatis-config.xml"));

		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("user/dao/userMapper.xml"));
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
	public HelloSpring helloSpring() {
		return new HelloSpring();
	}
	
	
	@Bean 
	public UserDTO userDTO() { 
		return new UserDTO(); 
	}
	
	/*
	 * @Bean public UserDAOMyBatis userDAOMyBatis() { return new UserDAOMyBatis(); } 
	 * 작은 규모에서는 안써도 스프링이 자동으로 찾아주나 큰 규모의 경우는 많아서 못찾으므로 써두는 것이 좋다.
	 */
	
	@Bean
	public UserInsertService userInsertService() {
		return new UserInsertService();
	}
	
	@Bean
	public UserSelectService userSelectService() {
		return new UserSelectService();
	}
	
	@Bean
	public UserUpdateService userUpdateService() {
		return new UserUpdateService();
		
	}
	
	@Bean
	public UserDeleteService userDeleteService() {
		return new UserDeleteService();
	}
	
	
	
}
