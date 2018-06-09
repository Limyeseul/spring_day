package org.comstudy21.myapp.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.myapp.commons.JdbcUtil;
import org.comstudy21.myapp.users.service.UserService;
import org.comstudy21.myapp.users.vo.UserVo;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements UserService {
	private Connection conn;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String USER_GET = "select * from users where id=? and password=?";
	private final String USER_INSERT = "insert into users (id,password,name,role)values(?,?,?,?)";
	private final String USER_UPDATE = "update users set password=?, name=?, role=? where id=?";
	private final String USER_DELETE = "delete from users where id=?";
	private final String USER_LIST = "select * from users";
	
	//회원등록
	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.users.dao.UserService#insertUser(org.comstudy21.myapp.users.vo.UserVo)
	 */
	@Override
	public void insertUser(UserVo vo){
		try {
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			int res  = stmt.executeUpdate();
			if(res>0) {
				System.out.println("입력 성공!");
				conn.commit();
			} else {
				System.out.println("입력 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
	}
	//회원정보수정
	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.users.dao.UserService#updateUser(org.comstudy21.myapp.users.vo.UserVo)
	 */
	@Override
	public void updateUser(UserVo vo) {
		try {
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, vo.getPassword());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getRole());
			stmt.setString(4, vo.getId());
			int res = stmt.executeUpdate();
			if(res>0) {
				System.out.println("수정완료!");
				conn.commit();
			} else {
				System.out.println("수정실패!");
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
		
	}
	//회원삭제
	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.users.dao.UserService#deleteUser(org.comstudy21.myapp.users.vo.UserVo)
	 */
	@Override
	public void deleteUser(UserVo vo) {
		try {
			stmt = conn.prepareStatement(USER_DELETE);
			stmt.setString(1, vo.getId());
			int res = stmt.executeUpdate();
			if(res>0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, stmt, conn);
		}
		
	}
	//회원상세조회
	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.users.dao.UserService#getUser(org.comstudy21.myapp.users.vo.UserVo)
	 */
	@Override
	public UserVo getUser(UserVo vo) {
		UserVo user = null;
		try {
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVo();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return user;
	}
	//회원목록조회
	/* (non-Javadoc)
	 * @see org.comstudy21.myapp.users.dao.UserService#getUserList(org.comstudy21.myapp.users.vo.UserVo)
	 */
	@Override
	public List<UserVo> getUserList(UserVo vo) {
		List<UserVo> list = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(USER_LIST);
			rs = stmt.executeQuery();
			while(rs.next()){
				UserVo user = new UserVo();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		return list;
	}
}
