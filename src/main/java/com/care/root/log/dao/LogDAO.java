package com.care.root.log.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.root.log.dto.LogDTO;

@Repository
public class LogDAO {
	private static String namespace = "com.care.board.logMapper";
	
	@Autowired
	SqlSession sqlSession;
	public List<LogDTO> logList(String start) {
		int startLog = Integer.parseInt(start);
		return sqlSession.selectList(namespace+".loglist", startLog);
	}
	
	public void saveLog(LogDTO dto) {
		int result = sqlSession.insert(namespace+".saveLog",dto);
		System.out.println("log result : "+result);
	}
	
	public int countLogNum() {
		return sqlSession.selectOne(namespace+".countLogNum");
	}
}
