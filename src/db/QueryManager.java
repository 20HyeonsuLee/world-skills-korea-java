package db;

import java.sql.ResultSet;

public enum QueryManager {

	LOGIN("select * from admin where name = ? and passwd = ?"),
	;
	
	final String sql;
	
	QueryManager(String sql) {
		this.sql = sql;
	}
	
	public QueryResult executeQuery(Object...values) {
		try {
			ResultSet rs = ConnectionManager.getStatement(sql, values).executeQuery();
			return new QueryResult(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void executeUpdate(Object...values) {
		try {
			ConnectionManager.getStatement(sql, values).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
