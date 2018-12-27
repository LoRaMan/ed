package cn.tuoren.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		String URL="jdbc:sqlserver://localhost:1433;DatabaseName=ed";
		String USER="ed";
		String PASSWORD="123456";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
		System.out.println("连接成功......");
		
		
		
	}
}
