package org.comstudy21.myweb.dao;

import java.sql.Connection;
import java.util.List;

import org.comstudy21.myweb.dto.SaramDto;

public class SaramDao implements Dao {
	private Connection conn;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(SaramDto dto) {
		System.out.println("insert >>> " + conn);
		
	}
	
	@Override
	public List<SaramDto> selectAll() {
		System.out.println("selectAll >>> " + conn);
		
		return null;
	}
	@Override
	public SaramDto selectOne(SaramDto dto) {
		
		return null;
	}
	@Override
	public void update(SaramDto dto) {
		
		
	}
	@Override
	public void delete(SaramDto dto) {
		
		
	}
	
	
	
}
