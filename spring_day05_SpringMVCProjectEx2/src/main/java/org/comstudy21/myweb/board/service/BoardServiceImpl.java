package org.comstudy21.myweb.board.service;

import java.util.List;

import org.comstudy21.myweb.board.dao.BoardDao;
import org.comstudy21.myweb.board.dao.BoardDaoMybatis;
import org.comstudy21.myweb.board.vo.BoardVo;
import org.omg.CORBA.BAD_INV_ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	//@Autowired //타입으로 연결한다.
	//private BoardDao boardDao;
	
	@Autowired
	private BoardDaoMybatis boardDao;
	
	@Override
	public void insertBoard(BoardVo vo) {
		boardDao.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVo vo) {
		boardDao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		boardDao.deleteBoard(vo);
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		return boardDao.getBoard(vo);
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		return boardDao.getBoardList(vo);
	}

}
