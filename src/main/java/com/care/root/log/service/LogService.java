package com.care.root.log.service;

import org.springframework.ui.Model;

import com.care.root.log.dto.LogDTO;

public interface LogService {
	public void saveLog(LogDTO dto);
	public int countLogNum();
	public void loglist(Model model, String start);
}
