package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import lombok.Setter;
import user.bean.UserDTO;

/*
 * public class UserDAOImpl implements UserDAO {
 * 
 * @Setter private JdbcTemplate jdbcTemplate;
 * 
 * @Override public void write(UserDTO userDTO) { String sql =
 * "insert into usertable values(?, ?, ?)"; jdbcTemplate.update(sql,
 * userDTO.getName(), userDTO.getId(), userDTO.getPwd());
 * 
 * }
 * 
 * }
 */

//public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO{
	@Override
	public void write(UserDTO userDTO) {
		//String sql = "insert into usertable values(?, ?, ?)";
		//getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
		
		
		String sql = "insert into usertable values(:name, :id, :pwd)";
		Map<String, String> map = new HashedMap<String, String>();
		map.put("id", userDTO.getId());
		map.put("name", userDTO.getName());
		map.put("pwd", userDTO.getPwd()); // 순서는 상관없다. 자기 이름을 찾아간다. ?의 개수가 많을때 유용하게 쓰인다.
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}
	
	public UserDTO getUser(String id){
		String sql = "select * from usertable where id=?";
		
		try {
			return getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class), id);
			
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	@Override
	public int getUserCount(String id) {
		String sql = "select count(*) from usertable where id=?";
		
		//return getJdbcTemplate().queryForObject(sql, new Object[] {id}, Integer.class);
		return getJdbcTemplate().queryForObject(sql, Integer.class, id); //이건 값을 하나만 넘길 수 있다.
	}
	
	public void modify(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id"; //맵에 순서대로 name pwd id를 저장했으면 ?로 해도 먹힌다.
		
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}
	
	@Override
	public void delete(String id) {
		String sql = "delete usertable where id=:id";
		//Map<String, String> map = new HashedMap<String, String>();
		//map.put("id", id);
		//getNamedParameterJdbcTemplate().update(sql, map);
		getJdbcTemplate().update(sql, id);
	}
	

	
	
}
