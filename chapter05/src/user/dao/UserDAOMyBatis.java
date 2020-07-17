package user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Transactional
public class UserDAOMyBatis implements UserDAO {
	private SqlSession sqlSession;
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void write(UserDTO userDTO) {
		int su = sqlSession.insert("userSQL.write", userDTO);

	}

	@Override
	public List<UserDTO> getUserList() {
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		list = sqlSession.selectList("userSQL.getUserList");
		
		return list;

	}

	@Override
	public UserDTO getUser(String id) {	
		try {
			return sqlSession.selectOne("userSQL.getUser", id);
			
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public int getUserCount(String id) {
		int su = sqlSession.selectOne("userSQL.getUserCount", id);
		
		return su;
		
	}

	@Override
	public void modify(Map<String, String> map) {
		
		sqlSession.update("userSQL.modify", map);
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
	}


}
