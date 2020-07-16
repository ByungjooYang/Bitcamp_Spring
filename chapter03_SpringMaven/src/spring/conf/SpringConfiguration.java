package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import sample01.LoggingAdvice;
import sample01.MessageBeanImpl;

@EnableAspectJAutoProxy
@Configuration
public class SpringConfiguration { //new bean 설정.
	@Bean
	public LoggingAdvice loggingAdvice() {
		return new LoggingAdvice();
	}
	
	@Bean
	public MessageBeanImpl messageBeanImpl() {
		return new MessageBeanImpl();
	}
	
}