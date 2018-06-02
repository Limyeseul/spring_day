package org.comstudy21.myapp.board.dao;

import java.util.List;

import org.comstudy21.myapp.board.vo.BoardVo;

public interface Dao {
	String INSERT_BOARD		= "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES ((SELECT NVL(MAX(SEQ),0)+1), ?, ?, ?)";
	String UPDATE_BOARD		= "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WHERE SEQ = ?";
	String DELETE_BOARD		= "DELETE FROM BOARD WHERE SEQ = ?";
	String SELECT_BOARD		= "SELECT * FROM BOARD WHERE SEQ = ?";
	String SELECT_BOARD_LIST= "SELECT * FROM BOARD ORDER BY DESC;";
	void insertBoard(BoardVo vo);
	void updateBoard(BoardVo vo);
	void deleteBoard(BoardVo vo);
	BoardVo getBoard(BoardVo vo);
	List<BoardVo> getBoardList(BoardVo vo);
	
}
