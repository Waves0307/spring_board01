package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;
@Service
public class MemberCheckServiceImpl implements MemberCheckService {
	@Autowired
	MemberDAO dao;
	//로그인 및 회원등록 시 id중복여부 처리
	public MemberDTO idChk(String id) {
		return dao.idChk(id);
	}
}
