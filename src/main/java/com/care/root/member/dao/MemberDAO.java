package com.care.root.member.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.care.root.member.dto.MemberDTO;
@Repository
public class MemberDAO {
	static final String namespace = "com.care.mybatis.myMapper";
	@Autowired
	SqlSession sqlSession;
	
	public List<MemberDTO> list() {
		return sqlSession.selectList(namespace+".memberList");
	}
	
	public MemberDTO idChk(String id) {
		System.out.println(id); //문자열 잘 출력됨
		MemberDTO dto = null;
		try {
			 dto = sqlSession.selectOne(namespace+".idChk",id);
		} catch (Exception e) {
			return dto;
		}
		return dto;
	}
	
	public void regist(HttpServletRequest req) {
		MemberDTO dto = new MemberDTO();
		dto.setId((String)req.getParameter("id"));
		dto.setPw((String)req.getParameter("pw"));
		dto.setAddr((String)req.getParameter("addr"));
		int result = sqlSession.insert(namespace+".regist",dto);
		System.out.println("result : "+result);
	}

}
