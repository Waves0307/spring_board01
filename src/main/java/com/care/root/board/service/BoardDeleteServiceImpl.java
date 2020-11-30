package com.care.root.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.root.board.dao.BoardDAO;
@Service
public class BoardDeleteServiceImpl implements BoardDeleteService{
	@Autowired
	BoardDAO dao;
	//게시글 삭제
	public void deleteBrd(String id) {
		dao.deleteBrd(id);
	}
}
