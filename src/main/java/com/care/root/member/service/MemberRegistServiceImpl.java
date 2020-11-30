package com.care.root.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.member.dao.MemberDAO;
@Service
public class MemberRegistServiceImpl implements MemberRegistService {
	@Autowired
	MemberDAO dao;
	
	//회원등록
	public void regist(HttpServletRequest req) {
		dao.regist(req);
	}
}
