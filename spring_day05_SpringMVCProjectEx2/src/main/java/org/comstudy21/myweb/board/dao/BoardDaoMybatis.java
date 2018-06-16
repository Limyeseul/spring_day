package org.comstudy21.myweb.board.dao;

import java.util.List;

import org.comstudy21.myweb.board.vo.BoardVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoMybatis implements Dao {
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void insertBoard(BoardVo vo) {
		mybatis.insert("BoardMapper.insertBoard", vo);
	}

	@Override
	public void updateBoard(BoardVo vo) {
		mybatis.update("BoardMapper.updateBoard", vo);
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		mybatis.delete("BoardMapper.deleteBoard", vo);
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		return mybatis.selectOne("BoardMapper.getBoard", vo);
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		return mybatis.selectList("BoardMapper.getBoardList", vo);
	}

}
