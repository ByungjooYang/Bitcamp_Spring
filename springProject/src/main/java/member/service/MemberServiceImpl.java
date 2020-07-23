package member.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

@Service 
public class MemberServiceImpl implements MemberService { //웹하고 상관없으니 root-context 에 달아준다.
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberDTO login(Map<String, String> map) {
			
		return memberDAO.login(map);
		
	}
}
