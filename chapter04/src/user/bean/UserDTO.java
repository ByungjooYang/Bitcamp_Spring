package user.bean;

import lombok.Data;

@Data
public class UserDTO {
	private String name;
	private String id;
	private String pwd;
	
	@Override
	public String toString() {
		return name + "\t" + id + "\t" + pwd;
	}
}
