package com.care.root.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.board.service.BoardDeleteService;
import com.care.root.board.service.BoardDeleteServiceImpl;
import com.care.root.board.service.BoardListService;
import com.care.root.board.service.BoardListServiceImpl;
import com.care.root.board.service.BoardModifyService;
import com.care.root.board.service.BoardModifyServiceImpl;
import com.care.root.board.service.BoardNumCountService;
import com.care.root.board.service.BoardNumCountServiceImpl;
import com.care.root.board.service.BoardRegistService;
import com.care.root.board.service.BoardRegistServiceImpl;
import com.care.root.board.service.BoardReplyService;
import com.care.root.board.service.BoardReplyServiceImpl;
import com.care.root.board.service.BoardViewService;
import com.care.root.board.service.BoardViewServiceImpl;
@Controller
@RequestMapping("board")
public class BoardController {
	private static final int PERPAGEBOARDNUM = 5;
	@Autowired
	BoardListService listService;
	@Autowired
	BoardRegistService regService;
	@Autowired
	BoardNumCountService brdCountService;
	@Autowired
	BoardModifyService modifyService;
	@Autowired
	BoardViewService viewService;
	@Autowired
	BoardDeleteService deleteService;
	@Autowired
	BoardReplyService replyService;
	
	@RequestMapping("list")
	public String board(Model model, @RequestParam (value="start", required=false) String start) {
		if (start == null) {
			start = "1";
		}
		int totalBoard = brdCountService.countBrd();
		int temp = (totalBoard / PERPAGEBOARDNUM );
		int totalPage = temp + ((totalBoard % PERPAGEBOARDNUM) == 0?0:1);
		model.addAttribute("start", start);
		model.addAttribute("totalPage", totalPage);
		listService.boardList(model, start);
		return "board/boardList";
	}
	@RequestMapping("regBrd")
	public String registBoard() {
		return "board/regBoard";
	}
	@PostMapping("saveBoard")
	public String saveBoard(HttpServletRequest req) {
		regService.registBoard(req);
		return "redirect:list";
	}
	@RequestMapping("boardInfo")
	public String boardInfo(@RequestParam("id") String id,Model model) { 
		// 글 제목을 눌렀을 경우 식별키인 id값을 request로 불러와야한다
		// 글 제목을 눌렀을 경우 조회수가 1 증가해야한다.
		model.addAttribute("boardInfo",viewService.viewBoard(id));
		return "board/boardInfo";
	}
	@RequestMapping("modifyBrd")
	public String modifyBrd(HttpServletRequest req) {
		modifyService.modifyBrd(req);
		return "redirect:list";
	}
	
	@RequestMapping("deleteBrd")
	public String deleteBrd(@RequestParam("id") String id) {
		deleteService.deleteBrd(id);
		return "redirect:list";
	}
	
	@RequestMapping("replyBrd")
	public String replyBrd(@RequestParam("id") String id,Model model) {
		model.addAttribute("boardInfo",viewService.viewBoard(id));
		return "board/reply";
	}
	@RequestMapping("replyBrdOk")
	public String replyBrdOk(HttpServletRequest req) {
		replyService.replyBrdOk(req);
		return "redirect:list";
	}
}
