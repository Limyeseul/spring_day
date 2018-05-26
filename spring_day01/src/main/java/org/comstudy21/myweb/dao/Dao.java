package org.comstudy21.myweb.dao;

import java.util.List;

import org.comstudy21.myweb.dto.SaramDto;

public interface Dao {
	public List<SaramDto> selectAll();
	
	public SaramDto selectOne(SaramDto dto);
	
	public void update(SaramDto dto);
	
	public void delete(SaramDto dto);
	
	public void insert(SaramDto dto);
}
