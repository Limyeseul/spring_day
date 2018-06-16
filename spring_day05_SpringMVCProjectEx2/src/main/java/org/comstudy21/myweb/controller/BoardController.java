package org.comstudy21.myweb.controller;

import java.util.List;

import org.comstudy21.myweb.board.service.BoardServiceImpl;
import org.comstudy21.myweb.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	@Qualifier("boardService")
	private BoardServiceImpl boardService;
	
	
	@RequestMapping("/list")
	public ModelAndView boardList(){
		ModelAndView modelAndView = new ModelAndView("board/board_list");
		
		List<BoardVo> boardList = boardService.getBoardList(null);
		modelAndView.addObject("boardList", boardList);
		
		return modelAndView;
	}
	
}
