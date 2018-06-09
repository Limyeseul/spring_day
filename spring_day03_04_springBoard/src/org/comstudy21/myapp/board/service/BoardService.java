package org.comstudy21.myapp.board.service;

import java.util.List;

import org.comstudy21.myapp.board.vo.BoardVo;

public interface BoardService {

	void insertBoard(BoardVo vo);

	void updateBoard(BoardVo vo);

	void deleteBoard(BoardVo vo);

	BoardVo getBoard(BoardVo vo);

	List<BoardVo> getBoardList(BoardVo vo);

}