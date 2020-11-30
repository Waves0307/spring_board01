package com.care.root.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.log.dao.LogDAO;
import com.care.root.log.dto.LogDTO;
@Service
public class LogServiceImpl implements LogService {
	@Autowired
	LogDAO dao;
	@Override
	public void saveLog(LogDTO dto) {
		dao.saveLog(dto);
	}
	@Override
	public int countLogNum() {
		return dao.countLogNum();
	}
	@Override
	public void loglist(Model model, String start) {
		model.addAttribute("logList",dao.logList(start));
	}
}
