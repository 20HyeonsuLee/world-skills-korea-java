package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String url = "jdbc:mysql://localhost/?serverTimezone=UTC&allowLoadLocalInfile=true";
	private static final String dbUrl = "jdbc:mysql://localhost/2016j?serverTimezone=UTC&allowLoadLocalInfile=true";
	private static final String user = "root";
	private static final String pass = "gustn346!@";
	
	private static Connection connection;

	public static PreparedStatement getStatement(String sql, Object...values) throws SQLException {
		PreparedStatement stmt = getConnection().prepareStatement(sql);
		for (int i = 0; i < values.length; ++i) stmt.setObject(i + 1, values[i]);
		return stmt;
	}
	
	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			return DriverManager.getConnection(dbUrl, user, pass);
		}
		return connection;
	}
	
	public static Connection getNoConnectedConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
}
