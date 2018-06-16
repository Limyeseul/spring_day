package org.comstudy21.myweb.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myweb.board.service.BoardService;
import org.comstudy21.myweb.board.vo.BoardVo;
import org.comstudy21.myweb.util.JdbcUtil;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao implements Dao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#insertBoard(org.comstudy21.myapp.board.vo.BoardVo)
	 */
	@Override
	public void insertBoard(BoardVo vo) {
		System.out.println("vo ====> " + vo);
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			int cnt = stmt.executeUpdate();
			if(cnt != 0) {
				System.out.println("입력 처리 성공!");
				conn.commit();
			} else {
				System.out.println("입력 처리 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
	}

	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#updateBoard(org.comstudy21.myapp.board.vo.BoardVo)
	 */
	@Override
	public void updateBoard(BoardVo vo) {
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			int cnt = stmt.executeUpdate();
			if(cnt!=0){
				System.out.println("수정 처리 성공!");
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
		
	}

	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#deleteBoard(org.comstudy21.myapp.board.vo.BoardVo)
	 */
	@Override
	public void deleteBoard(BoardVo vo) {
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			int cnt = stmt.executeUpdate();
			if(cnt!=0) {
				System.out.println("수정 처리 완료!");
				conn.commit();
			} else {
				System.out.println("수정 처리 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
	}

	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#getBoard(org.comstudy21.myapp.board.vo.BoardVo)
	 */
	@Override
	public BoardVo getBoard(BoardVo vo) {
		BoardVo board = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVo();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setCnt(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return board;
	}

	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.board.dao.BoardService#getBoardList(org.comstudy21.myapp.board.vo.BoardVo)
	 */
	@Override
	public List<BoardVo> getBoardList(BoardVo vo) {
		List<BoardVo> list = new ArrayList<>();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVo board = new BoardVo();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setRegDate(rs.getDate(5));
				board.setCnt(rs.getInt(6));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		
		return list;
	}
	
}
