package member.service;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberService {

	public MemberDTO login(Map<String, String> map);

	public String checkId(String id);

	public List<ZipcodeDTO> postSearch(Map<String, String> map);

	public MemberDTO getMember(String id);

	public void modify(MemberDTO memberDTO);

	public void write(MemberDTO memberDTO);

}
