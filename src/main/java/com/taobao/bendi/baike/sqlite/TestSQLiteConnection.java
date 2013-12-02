package com.taobao.bendi.baike.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestSQLiteConnection {
	
	private static String dbfile = "D:/software/sqlite/db/baike";
	/**
	* @param args
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			long start = System.currentTimeMillis();
			// 连接SQLite的JDBC
			Class.forName("org.sqlite.JDBC");

			// 建立一个数据库名test.db的连接，如果不存在就在当前目录下创建之
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+dbfile);
			long end = System.currentTimeMillis();
			System.out.println("创建数据库文件并连接耗费时间：" + (end - start));
			
			
			Statement statement = conn.createStatement();
		    statement.setQueryTimeout(30);  // set timeout to 30 sec
		    //statement.executeUpdate("insert into user (id, name, type) values (1,'baike',0)");
		    ResultSet rs = statement.executeQuery("select * from user");
		    if(rs != null) {
		    	while(rs.next()) {
		    		System.out.println(rs.getString(2));
		    	}
		    }else {
		    	System.out.println("NULL");
		    }
			
			conn.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
