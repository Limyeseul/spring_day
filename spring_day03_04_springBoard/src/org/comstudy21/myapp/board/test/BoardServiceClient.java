package org.comstudy21.myapp.board.test;

import java.util.List;
import java.util.Scanner;

import org.comstudy21.myapp.board.service.BoardService;
import org.comstudy21.myapp.board.vo.BoardVo;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		String resources = "applicationContext.xml";
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext(resources);
		
		BoardService boardService = (BoardService)factory.getBean("boardService");
		
		BoardVo board = new BoardVo();
		System.out.print("제목입력>>> ");
		board.setTitle(scan.next());
		System.out.print("작성자입력>>> ");
		board.setWriter(scan.next());
		System.out.print("내용입력>>> ");
		board.setContent(scan.next());
		System.out.println("board ===> " + board);
		boardService.insertBoard(board);
		
		List<BoardVo> boardList = boardService.getBoardList(null);
		System.out.println("게시판 목록 서비스 테스트 >>> " + boardList);
		for(BoardVo vo : boardList) {
			System.out.println(vo);
		}
	}

}
