package org.comstudy21.myapp.users.service;

import java.util.List;

import org.comstudy21.myapp.users.vo.UserVo;

public interface UserService {

	//회원등록
	void insertUser(UserVo vo);

	//회원정보수정
	void updateUser(UserVo vo);

	//회원삭제
	void deleteUser(UserVo vo);

	//회원상세조회
	UserVo getUser(UserVo vo);

	//회원목록조회
	List<UserVo> getUserList(UserVo vo);

}