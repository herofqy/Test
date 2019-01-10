package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class TestJDBC {
	private static String jdbcUrl = "jdbc:mysql://118.24.128.77:3306/demo";
	private static String driverClassName = "com.mysql.cj.jdbc.Driver";
	private static String username = "root";
	private static String password = "root123";
	
	@Test
	public void exec() throws Exception {
		exe(jdbc());
		exe(hikari1());
		exe(hikari2());
	}
	
	static Connection jdbc() throws Exception {
		Class.forName(driverClassName).newInstance();
		return DriverManager.getConnection(jdbcUrl, username, password);
	}
	
	static Connection hikari1() throws Exception {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(username);
		config.setPassword(password);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.setDriverClassName(driverClassName);
		HikariDataSource ds = new HikariDataSource(config);
		return ds.getConnection();
	}
	
	static Connection hikari2() throws Exception {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(jdbcUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.addDataSourceProperty("cachePrepStmts", "true");
		ds.addDataSourceProperty("prepStmtCacheSize", "250");
		ds.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		ds.setDriverClassName(driverClassName);
		Connection conn = ds.getConnection();
		return conn;
	}
	
	static void exe(Connection conn)  throws Exception {
		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select name from user;");
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		conn.close();
	}
}
