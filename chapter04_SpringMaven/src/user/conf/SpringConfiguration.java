package user.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource =  new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##java");
		dataSource.setPassword("bit");
		dataSource.setMaxTotal(20);
		dataSource.setMaxIdle(3);
		return dataSource;
	}
	
	
	
}


