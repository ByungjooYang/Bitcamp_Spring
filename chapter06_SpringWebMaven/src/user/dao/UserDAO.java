package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {

	public UserDTO checkId(String id);

	public void write(UserDTO userDTO);

	public void delete(String id);

	public List<UserDTO> getUserList();

	public void modify(UserDTO userDTO);

	public List<UserDTO> getSearchList(String searchOption, String searchText);


}
