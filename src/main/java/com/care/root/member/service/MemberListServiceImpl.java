package com.care.root.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
@Service
public class MemberListServiceImpl implements MemberListService{
	@Autowired
	MemberDAO dao;
	//멤버리스트 출력
	public void list(Model model) {
		model.addAttribute("list",dao.list());
	}
}
