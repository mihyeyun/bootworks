package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.domain.Board;
import com.boot.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model) {
		log.info("getBoardList 진입");
		List<Board> boardList = service.getBoardList();
		model.addAttribute("boardList", boardList);
		return "getBoardList"; // getBoardList.jsp
	}
	
	//새글 등록 폼 페이지 요청
	@GetMapping("/insertBoard")
	public String insertBoard() {
		log.info("insertBoard 페이지 진입");
		return "insertBoard";
	}
	
	//새글 등록 처리
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		log.info("insertBoard service 진입 요청");
		service.insertBoard(board);
		log.info("insertBoard service 진행 완료");
		return "redirect:/getBoardList";
	}
	
	//상세 보기
	@GetMapping("/getBoard")
	public String getBoard(Long seq, Model model) {
		log.info("조회수 증가 요청");
		service.updateCount(seq);
		log.info("조회수 증가 완료");
		log.info("getBoard 페이지 진입");
		Board board = service.getBoard(seq);
		model.addAttribute("board", board);
		log.info("getBoard 조회 완료");
		return "getBoard";
	}
	
	//글 삭제하기
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		log.info("deleteBoard 페이지 진입");
		service.deleteBoard(board);
		log.info("deleteBoard 진행 완료");
		return "redirect:/getBoardList";
	}
	
	//글 수정하기
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		log.info("updateBoard 페이지 진입");
		service.updateBoard(board);
		log.info("updateBoard 진행 완료");
		return "redirect:/getBoardList";
	}
	
	//main 페이지 이동
	/*@RequestMapping(value="/")
	public String index() {
		log.info("main 페이지 진입");
		return "index";
	}*/
}
