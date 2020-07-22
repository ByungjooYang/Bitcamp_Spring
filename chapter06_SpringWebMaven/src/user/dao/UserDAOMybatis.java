package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Transactional
@Repository
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDTO checkId(String id) {
		return sqlSession.selectOne("userSQL.checkId", id);
	}

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
	}

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
		
	}

	@Override
	public void modify(UserDTO userDTO) {
		System.out.println(userDTO.getId() + userDTO.getName());
		sqlSession.update("userSQL.modify", userDTO);
	}

	@Override
	public List<UserDTO> getSearchList(String searchOption, String searchText) {
		Map<String, String> map = new HashedMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("searchText", searchText);
		
		return sqlSession.selectList("userSQL.getSearchList", map);
		
	}

}
