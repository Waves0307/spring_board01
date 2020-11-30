package com.care.root.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.care.root.log.dto.LogDTO;
import com.care.root.log.service.LogService;

@Aspect
@Component
public class LoginOutTimeSave {
	@Autowired
	LogService ls;
	private String startTime;
	private Long resultStartTime;
	
	@After("execution(* com.care.root.member.controller.MemberController.loginCheck(..))")
	public void loginTimeSave(JoinPoint joinPoint) {
		System.out.println("로그인 후 공통기능 시작!!");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		Date date = new Date();
		startTime = sdf.format(date);
		resultStartTime = date.getTime();
		System.out.println("로그인 후 공통기능 종료!!");
	}
	
	@Before("execution(* com.care.root.member.controller.MemberController.logout(..))")
	public void logoutTimeSave(JoinPoint joinPoint) {
		System.out.println("로그아웃 전 공통기능 시작!!");
		LogDTO dto = new LogDTO();
		//해당 joinPoint에 있는 메소드의 변수들을 가져올 수 있다.
		Object[] argments = joinPoint.getArgs();
		HttpSession session = null;
		String id = "";
		for (Object tmp: argments) {
			if(tmp instanceof HttpSession) {
				session = (HttpSession)tmp;
				id = (String)session.getAttribute("id");
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		Date date = new Date();
		Long resultTimeEnd = date.getTime();
		String endTime = sdf.format(date);
		
		dto.setId(id);
		dto.setEndTime(endTime);
		dto.setStartTime(startTime);
		try {
			int resultTime = (int)(resultTimeEnd - resultStartTime)/1000;
			dto.setResultTime(resultTime);
			ls.saveLog(dto);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		System.out.println("로그아웃 전 공통기능 종료!!");
	}
}
