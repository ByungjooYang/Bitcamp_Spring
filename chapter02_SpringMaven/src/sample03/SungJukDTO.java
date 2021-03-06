package sample03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
//@Component
@ComponentScan("spring.config")
public class SungJukDTO {
	private @Value("홍길동")String name;
	private @Value("90")int kor;
	private @Value("83")int eng;
	private @Value("72")int math;
	private int tot;
	private double avg;
	
	@Override
	public String toString() {
		return name + "\t" + kor + "\t" +  eng  + "\t" + math  + "\t" + tot  + "\t" +  avg;
	}
}
