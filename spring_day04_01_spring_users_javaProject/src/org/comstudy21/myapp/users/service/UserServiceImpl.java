package org.comstudy21.myapp.users.service;

import java.util.List;

import org.comstudy21.myapp.commons.JdbcUtil;
import org.comstudy21.myapp.users.dao.UserDao;
import org.comstudy21.myapp.users.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void insertUser(UserVo vo) {
		userDao.setConnection(JdbcUtil.getConnection());
		userDao.insertUser(vo);
	}

	@Override
	public void updateUser(UserVo vo) {
		userDao.setConnection(JdbcUtil.getConnection());
		userDao.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVo vo) {
		userDao.setConnection(JdbcUtil.getConnection());
		userDao.deleteUser(vo);
	}

	@Override
	public UserVo getUser(UserVo vo) {
		userDao.setConnection(JdbcUtil.getConnection());
		return userDao.getUser(vo);
	}

	@Override
	public List<UserVo> getUserList(UserVo vo) {
		userDao.setConnection(JdbcUtil.getConnection());
		return userDao.getUserList(vo);
	}
}
