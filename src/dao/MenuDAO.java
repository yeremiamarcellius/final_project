package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import db.dbConnect;

public class MenuDAO {

	Connection connection;
	
	public MenuDAO() {
		// TODO Auto-generated constructor stub
		try {
			initDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initDB() throws SQLException {
		connection = dbConnect.connect();
		if(connection == null) {
			throw new SQLException("connection");
		}
	}
	
	public Vector<Vector<String>> getData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from menus";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				data.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public void insertData(String nama, String harga, String stock) {
		try {
			Statement stmt = connection.createStatement();
			String kode = getRandomID();
			String sql = "insert into menus values ('"+ kode +"', '"+ nama +"', '"+harga+"', '"+stock+"')";
			stmt.executeUpdate(sql);
			System.out.println("Success Input Data");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getRandomID() {
		int num1 = (int)(Math.random()*(9-0+1));
		int num2 = (int)(Math.random()*(9-0+1));
		int num3 = (int)(Math.random()*(9-0+1));
		String kode = "BC-"+num1+num2+num3;
		return kode;
	}
	
	public void updateData(String id, String nama, String harga, String stock) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "update menus set nama_menu='" + nama + "',harga_menu='" + harga + "', stock_menu='" + stock + "' where kode_menu='" + id + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteData(String id) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "delete from menus where kode_menu='" + id + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

