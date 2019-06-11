package com.lti.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnectionUtil {
	public static Connection getConnection() {
		try {
			FileReader fr = new FileReader(
					"C:\\Users\\User\\Desktop\\CoreJava\\servlet-jsp-jdbc-demo\\src\\main\\webapp\\WEB-INF\\db.properties");
			Properties properties = new Properties();
			properties.load(fr);
			Class.forName(properties.getProperty("driverName"));
			String url = properties.getProperty("url");
			String un = properties.getProperty("username");
			String pw = properties.getProperty("password");
			Connection connection = DriverManager.getConnection(url, un, pw);
			return connection;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
