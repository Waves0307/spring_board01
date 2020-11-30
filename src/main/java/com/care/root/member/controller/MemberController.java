package com.care.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.member.dto.MemberDTO;
import com.care.root.member.service.MemberCheckService;
import com.care.root.member.service.MemberCheckServiceImpl;
import com.care.root.member.service.MemberListService;
import com.care.root.member.service.MemberListServiceImpl;
import com.care.root.member.service.MemberRegistService;
import com.care.root.member.service.MemberRegistServiceImpl;

//컨트롤러는 그냥 연결만 시켜주는 역할!!
@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	private MemberCheckService checkService;
	@Autowired
	private MemberListService listService;
	@Autowired
	private MemberRegistService regService;
	@RequestMapping("index")
	public String test() {
		return "member/index";
	}
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	@RequestMapping("memberReg")
	public String memberReg() {
		return "member/memberReg";
	}
	
	@PostMapping("registerChk")
	public String registerOk(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		if (checkService.idChk(id) != null) { //일치하는 아이디가 있는 경우
			model.addAttribute("reg",1); 
			return "member/regChk";
		} else { // 일치하는 아이디가 없는 경우 insert쿼리 실행
			regService.regist(req); //
			model.addAttribute("reg",2);
			return "member/regChk";
		}
	}
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate(); //로그아웃 시 세션 삭제
		System.out.println("로그아웃 핵심기능 실행");
		return "member/index";
	}
	@PostMapping("loginCheck")
	public String loginCheck(@RequestParam("id") String id, @RequestParam("pw") String pw
			, Model model, HttpSession session) {
		MemberDTO dto = checkService.idChk(id);
		System.out.println("로그인 핵심기능 실행");
		if (dto == null) {
			model.addAttribute("check", 1); //존재하는 아이디 없음
			return "member/loginChk";
		} else {
			if (id.equals(dto.getId()) && pw.equals(dto.getPw())) {
				session.setAttribute("id", id);
				return "member/successLogin";
			} else {
				model.addAttribute("check", 2);
				return "member/loginChk";
			}
		}
	}
	
	@RequestMapping("membershipInfo")
	public String membershipInfo(Model model) {
		listService.list(model);
		return "member/membershipInfo";		
	}
	
	@RequestMapping("memberInfo")
	public String memberInfo(Model model, @RequestParam("id") String id) {
		//특정 멤버의 id,pw를 dto객체에 저장 : id pw 찾을때와 같은 메소드를
		//사용하므로 같은 서비스를 이용
		model.addAttribute("dto", checkService.idChk(id));
		return "member/memberInfo";
	}
}
