package utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import launcher.Program;

public class DButils {
	private static Properties p;
	static {
		try {
			p = new Properties();
			InputStream inputStream = Program.class.getClassLoader().getResourceAsStream("config.properties");
			p.load(inputStream);
			Class.forName(p.getProperty("DRIVER"));
		}catch (Exception cause) {
			throw new RuntimeException( cause );
		}
	}
	public static Connection getConnection( )throws Exception{
		return DriverManager.getConnection(p.getProperty("URL"), p.getProperty("USER"), p.getProperty("PASSWORD"));
	}
}