package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnHelp {

	static {
		// 1����װ����
		Driver driver = null; // Driver�ǽӿ�
		driver = new org.mariadb.jdbc.Driver(); // ������ʵ�֣����ɾ�������ݿ⳧��ʵ�֡�
		try {
			DriverManager.registerDriver(driver);// DriverManager��JDBC�в����ʵ���ࡣ
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		Connection c = null;
		c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/location", "gg", "123456");
		return c;
	}
}
