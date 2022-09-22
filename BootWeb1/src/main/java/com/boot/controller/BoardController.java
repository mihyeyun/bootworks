package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.boot.domain.Board;
import com.boot.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/hello")
	public String hello() {
		log.info("hello Page 진입");
		return "hello";
	}
	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model) {
		log.info("getBoardList 진입");
		List<Board> boardList = service.getBoardList();
		model.addAttribute("boardList", boardList);
		return "getBoardList"; // getBoardList.jsp
	}
}
