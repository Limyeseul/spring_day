package org.comstudy21.myapp.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.comstudy21.myapp.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoSpring implements Dao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertBoard(BoardVo vo) {
		System.out.println(">>> Spring JDBC로 insertBoard()처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	@Override
	public void updateBoard(BoardVo vo) {
		System.out.println(">>> Spring JDBC로 updateBoard()처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		System.out.println(">>> Spring JDBC로 deleteBoard()처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		System.out.println(">>> Spring JDBC로 getBoard()처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		System.out.println(">>> Spring JDBC로 getBoardList()처리");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}

class BoardRowMapper implements RowMapper<BoardVo> {
	@Override
	public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVo board = new BoardVo();
		board.setSeq(rs.getInt("seq"));
		board.setTitle(rs.getString(2));
		board.setWriter(rs.getString(3));
		board.setContent(rs.getString(4));
		board.setRegDate(rs.getDate(5));
		board.setCnt(rs.getInt(6));
		return board;
	}
}
