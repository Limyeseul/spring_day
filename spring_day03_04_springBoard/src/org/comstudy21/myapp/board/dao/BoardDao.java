package org.comstudy21.myapp.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.Border;

import org.comstudy21.myapp.board.vo.BoardVo;
import org.comstudy21.myapp.util.JdbcUtil;

public class BoardDao implements Dao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	@Override
	public void insertBoard(BoardVo vo) {
		try {
			conn = JdbcUtil.getconnection();
			stmt = conn.prepareStatement(INSERT_BOARD);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			
			int count = stmt.executeUpdate();
			
			if(count != 0) {
				System.out.println("처리 성공");
				conn.commit();
			} else {
				System.out.println("처리 실패");
			}
			
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}

	@Override
	public void updateBoard(BoardVo vo) {
		try {
			conn = JdbcUtil.getconnection();
			stmt = conn.prepareStatement(UPDATE_BOARD);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			int count = stmt.executeUpdate();
			
			if(count != 0) {
				System.out.println("처리 성공");
				conn.commit();
			} else {
				System.out.println("처리 실패");
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}

	@Override
	public void deleteBoard(BoardVo vo) {
		try {
			conn = JdbcUtil.getconnection();
			stmt = conn.prepareStatement(DELETE_BOARD);
			stmt.setInt(1, vo.getSeq());
			
			int count = stmt.executeUpdate();
			
			if(count != 0) {
				System.out.println("처리 성공");
				conn.commit();
			} else {
				System.out.println("처리 실패");
			}
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
	}

	@Override
	public BoardVo getBoard(BoardVo vo) {
		BoardVo info = null;

		try {
			conn = JdbcUtil.getconnection();
			stmt = conn.prepareStatement(SELECT_BOARD);
			stmt.setInt(1, vo.getSeq());
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				info = new BoardVo();
				info.setSeq(rs.getInt("SEQ"));
				info.setTitle(rs.getString("TITLE"));
				info.setWriter(rs.getString("WRITER"));
				info.setContent(rs.getString("CONTENT"));
				info.setRegDate(rs.getDate("REGDATE"));
				info.setCnt(rs.getInt("CNT"));
			}
			
			return info;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return info;
	}

	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		List<BoardVo> listInfo = null;
		BoardVo info = null;

		try {
			conn = JdbcUtil.getconnection();
			stmt = conn.prepareStatement(SELECT_BOARD);
			stmt.setInt(1, vo.getSeq());
			
			rs = stmt.executeQuery();
			
			listInfo = new ArrayList<BoardVo>();
			
			while(rs.next()) {
				info = new BoardVo();
				info.setSeq(rs.getInt("SEQ"));
				info.setTitle(rs.getString("TITLE"));
				info.setWriter(rs.getString("WRITER"));
				info.setContent(rs.getString("CONTENT"));
				info.setRegDate(rs.getDate("REGDATE"));
				info.setCnt(rs.getInt("CNT"));
				
				listInfo.add(info);
			}
			
			return listInfo;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, stmt, rs);
		}
		return listInfo;
	}
	
}
