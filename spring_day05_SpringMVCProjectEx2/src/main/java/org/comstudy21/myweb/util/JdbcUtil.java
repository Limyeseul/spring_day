package org.comstudy21.myweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil implements JdbcProperties {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(CLASS_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection 실패!");
			e.printStackTrace();
		}
		return conn;
	}
	
	//close 메소드를 Override 한다.
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		close(rs);
		close(stmt);
		close(conn);
	}
	public static void close(Connection obj){
		if(obj != null) {
			try {
				obj.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Statement obj){
		if(obj != null) {
			try {
				obj.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet obj){
		if(obj != null) {
			try {
				obj.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
