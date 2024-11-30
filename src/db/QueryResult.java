package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QueryResult {
	private final List<List<Object>> data = new ArrayList<>();
	
	QueryResult(ResultSet rs) throws Exception {
		while(rs.next()) data.add(convertRow(rs));
	}
	
	private List<Object> convertRow(ResultSet rs) throws Exception {
		List<Object> row = new ArrayList<>();
		for (int i = 0; i < rs.getMetaData().getColumnCount(); ++i) {
			row.add(rs.getObject(i + 1));
		}
		return row;
	}
	
	public String getString(int rowIndex, int columnIndex) {
		return data.get(rowIndex).get(columnIndex).toString();
	}
	
	public int getInt(int rowIndex, int columnIndex) {
		return Integer.parseInt(data.get(rowIndex).get(columnIndex).toString());
	}
	
	public int size() {
		return data.size();
	}
}
