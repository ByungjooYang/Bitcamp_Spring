package spring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample03.SungJukDTO;
import sample03.SungJukImpl;
import sample05.HelloSpring;
import sample05.SungJukDTO2;
import sample05.SungJukInput;

@Configuration
public class SpringConfiguration { //new bean 설정.
	//메소드명을 객체명으로 인식한다. SungJukImpl getSungJukImpl = new SungJukImpl(); 이렇게 선언한것과 같음
	//bean 명을 getSungJukImpl로 찾는데 메소드 명과 bean명이 다르므로  name="sungJukImple"을 부여한것.
	@Bean(name="sungJukImpl")
	public SungJukImpl getSungJukImpl() {	
		return new SungJukImpl();
	}
	
	/*@Bean //이렇게 해도 됨
	public SungJukImpl sungJukImpl() {	
		return new SungJukImpl();
	}*/
	
	@Bean
	public SungJukDTO sungJukDTO() {
		return new SungJukDTO();
	}
	
	@Bean
	public List<SungJukDTO2> list(){
		return new ArrayList<SungJukDTO2>();
	}
	
}
