package com.javalec.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javalec.base.LogIn;
import com.javalec.base.MenuMain;
import com.javalec.base.Welcome;
import com.javalec.util.DBConnect;

public class DaoDetail {
	private int hotice;
	private int quantity;
	private int syrup;
	private int shot;
	private int size;
	
	public DaoDetail() {
		// TODO Auto-generated constructor stub
	}
	
	// insertToOrder 시 생성자 
	public DaoDetail(int hotice, int quantity, int shot, int syrup, int size) {
		super();
		this.hotice = hotice;
		this.quantity = quantity;
		this.syrup = shot;
		this.shot = syrup;
		this.size = size;
	}
	
	

	public DaoDetail(int syrup, int shot, int size) {
		super();
		this.syrup = syrup;
		this.shot = shot;
		this.size = size;
	}

	public boolean insertToOrder() {
		
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 
			String query = "insert into noon.order (hotice, quantity, shot, syrup, size, forheretogo, set_menu_name, staff_id, indiprice, set_setno, shop_shopcode, ordertime, member_id) ";
			String query1 = "values (?,?,?,?,?,?,?,?,?,?,?,now(),?)";

			ps = conn_mysql.prepareStatement(query + query1);
			ps.setInt(1, hotice);
			ps.setInt(2, quantity);
			ps.setInt(3, shot);
			ps.setInt(4, syrup);
			ps.setInt(5, size);
			ps.setString(6, Welcome.forHereToGo);
			ps.setString(7, MenuMain.menuname);
			ps.setString(8, LogIn.kiosk_id);
			ps.setInt(9, indiPrice());
			ps.setInt(10, settingSetNo());
			ps.setInt(11, shopShopCode());
			ps.setString(12, "guest");
			
			ps.executeUpdate(); 

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public int indiPrice() {
		String whereStatement = "select pricenow from setting ";
		String whereStatement2 = "where menu_name = '" + MenuMain.menuname + "' and enddate is null";
		
		int indiPrice = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if(rs.next()) {
				indiPrice = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}
		
		indiPrice = indiPrice + syrup + shot + size;
		
		return indiPrice;
	}
	
	public int settingSetNo() {
		// select setno from setting where menu_name = 'MenuMain.menuname' and enddate is null
		String whereStatement = "select setno from setting ";
		String whereStatement2 = "where menu_name = '" + MenuMain.menuname + "' and enddate is null";
		
		int setno = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection (DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if(rs.next()) {
				setno = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}

		return setno;		
	}
	
	public int shopShopCode() {
		String whereStatement = "select shop_shopcode from hire ";
		String whereStatement2 = "where staff_id = '" + LogIn.kiosk_id + "' and deletedate is null";
		
		int shopcode = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw_mysql); 
			Statement stmt_mysql = conn_mysql.createStatement(); 
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if(rs.next()) {
				shopcode = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace(); // 개발 할 때는 이렇게, product를 만들 때는 경고문장을 넣어주면 된다.
		}

		return shopcode;		
	}
}
