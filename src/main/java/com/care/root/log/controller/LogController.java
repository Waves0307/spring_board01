package com.care.root.log.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.log.service.LogService;

@Controller
@RequestMapping("log")
public class LogController {
	private static final int PERPAGELOGNUM = 10;
	@Autowired
	LogService service;	
	@RequestMapping("logList")
	public String logList(Model model, @RequestParam (value="start", required = false ) String start) {
		if (start == null) {
			start = "1";
		}
		int totalLogNum = service.countLogNum();
		int temp = (totalLogNum / PERPAGELOGNUM);
		int totalPage = temp + ((totalLogNum % PERPAGELOGNUM) == 0?0:1);
		model.addAttribute("start",start);
		model.addAttribute("totalPage",totalPage);
		service.loglist(model,start);
		return "log/logList";
		
	}
}
