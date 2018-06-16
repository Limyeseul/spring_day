package org.comstudy21.myweb.board.dao;

import java.util.List;

import org.comstudy21.myweb.board.vo.BoardVo;

public interface Dao {
	//SQL 명령어들
	String BOARD_INSERT = "insert into board(SEQ,title,writer,content) "+
					"values( (select nvl(max(SEQ),0)+1 from board),?,?,?)";
	String BOARD_UPDATE = "update board set tittle=?, content=? where seq=?";
	String BOARD_DELETE = "delete from board where seq=?";
	String BOARD_GET = "select * from board where seq=?";
	String BOARD_LIST = "select * from board order by SEQ desc";
	//글 입력
	void insertBoard(BoardVo vo);
	//글 수정
	void updateBoard(BoardVo vo);
	//글 삭제
	void deleteBoard(BoardVo vo);
	//상세 조회
	BoardVo getBoard(BoardVo vo);
	//글 목록 조회
	List<BoardVo> getBoardList(BoardVo vo);
}
