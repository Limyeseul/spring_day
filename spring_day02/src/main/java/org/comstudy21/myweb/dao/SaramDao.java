package org.comstudy21.myweb.dao;

import org.comstudy21.myweb.dto.SaramDto;
import org.mybatis.spring.SqlSessionTemplate;

public class SaramDao {
	private SqlSessionTemplate myBatis;
	
	// DI
	public void setMyBatis(SqlSessionTemplate myBatis) {
		this.myBatis = myBatis;
	}
	
	public SaramDto getById(String id) {
		return myBatis.selectOne("SaramMapper.selectSaram", "HONG");
	}
}
