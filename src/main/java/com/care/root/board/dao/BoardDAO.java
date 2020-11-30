package com.care.root.board.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.care.root.board.dto.BoardDTO;
@Repository
public class BoardDAO {
	static final String namespace = "com.care.board.boardMapper";
	@Autowired
	SqlSession sqlSession;
	
	public List<BoardDTO> boardList(String start) {
		int startBrd = Integer.parseInt(start);
		return sqlSession.selectList(namespace+".brdList", startBrd);
	}
	public void registBoard(HttpServletRequest req) {
		BoardDTO dto = new BoardDTO();
		dto.setName((String)req.getParameter("name"));
		dto.setTitle((String)req.getParameter("title"));
		dto.setContent((String)req.getParameter("content"));
		int result = sqlSession.insert(namespace+".registBoard",dto);
		System.out.println("result : "+result);
	}
	
	public BoardDTO viewBoard(String id) {
		BoardDTO dto = new BoardDTO();
		sqlSession.update(namespace+".hitUp",id);
		//게시물 정보를 불러오기 위해 select 쿼라문 실행
		dto = sqlSession.selectOne(namespace+".viewBoard",id);
		//게시물 조회수를 1 상승 시키기 위해 update 쿼리문 실행
		return dto;
	}
	public int countBrd() { 
		return sqlSession.selectOne(namespace+".countBrd");
	}
	public void modifyBrd(HttpServletRequest req) {
		BoardDTO dto = new BoardDTO();
		dto.setId(Integer.parseInt(req.getParameter("id")));
		dto.setName((String)req.getParameter("name"));
		dto.setTitle((String)req.getParameter("title"));
		dto.setContent((String)req.getParameter("content"));
		int result = sqlSession.update(namespace+".modifyBrd", dto);
		System.out.println("result : "+result);
	}
	public void deleteBrd(String id) {
		int delId = Integer.parseInt(id);
		int result = sqlSession.delete(namespace+".deleteBrd",delId);
		System.out.println("result : "+result);
	}
	public void replyBrdOk(HttpServletRequest req) {
		BoardDTO dto = new BoardDTO();
		dto.setName((String)req.getParameter("name"));
		dto.setTitle((String)req.getParameter("title"));
		dto.setContent((String)req.getParameter("content"));
		dto.setIdgroup(Integer.parseInt(req.getParameter("idgroup")));
		dto.setStep(Integer.parseInt(req.getParameter("step"))+1);
		dto.setIndent(Integer.parseInt(req.getParameter("indent"))+1);
		sqlSession.insert(namespace+".replyBrdOk", dto);
	}
}
