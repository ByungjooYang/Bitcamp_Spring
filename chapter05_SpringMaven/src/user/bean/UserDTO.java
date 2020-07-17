package user.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ComponentScan("user.conf") //@Component 라고 써도 될때 있는데 안될때도 있으니 그냥 쓰즈아
public class UserDTO {
	private String name;
	private String id;
	private String pwd;
	
	@Override
	public String toString() {
		return name + "\t" + id + "\t" + pwd;
	}
}
