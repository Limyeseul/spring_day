package org.comstudy21.myweb;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.comstudy21.myweb.dto.SaramDto;

public class SaramServiceClient {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";

			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			// do work
			SqlSession session = sqlSessionFactory.openSession();
			SaramDto saram = session.selectOne("SaramMapper.selectSaram", "HONG");
			System.out.println(saram);
		
			session.close();
	}

}
