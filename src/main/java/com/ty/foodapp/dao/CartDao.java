package com.ty.foodapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ty.foodapp.dto.Cart;
 
import com.ty.foodapp.dto.Company;

public class CartDao {
	static Connection con = null;
	static PreparedStatement pstm = null;
	static Statement stm = null;
	static ResultSet rs = null;

	private static String url = "jdbc:postgresql://localhost:5432/foodapp_jdbc";
	private static String user = "postgres";
	private static String password = "ROOT";

	static {

		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static Cart CreateCart(Cart cart) {
		String query = "INSERT INTO cart VALUES(?,?,?,?,?,?)";

		try {
			pstm = con.prepareStatement(query);

			pstm.setInt(1, cart.getId());
			pstm.setString(2, cart.getCreatedDateAndTime());
			pstm.setString(3, cart.getItemInfo());
			pstm.setLong(4, cart.getQuantity());
			pstm.setString(5, cart.getStatus());
			pstm.setString(6, cart.getDeliveredDateAndTime());

			int count = pstm.executeUpdate();

			if (count==1) {
				return cart;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;

	}

	public static List<Cart> changeStatusOfOrder(String list) {
		String query = "select * from cart where cart_status=?";

		List<Cart> cartList = new ArrayList<Cart>();
		try {
			pstm = con.prepareStatement(query);
			pstm.setString(1, list);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Cart cart3 = new Cart();

				cart3.setId(rs.getInt(1));
				cart3.setItemInfo(rs.getString(3));
				cart3.setStatus(rs.getString(5));

				cartList.add(cart3);

				cart3.setCreatedDateAndTime(rs.getString(2));
				cart3.setQuantity(rs.getInt(4));
				cart3.setDeliveredDateAndTime(rs.getString(6));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return cartList;
	}

	public static List<Cart> updateStatus(Cart cart3) {
		String query = "UPDATE cart set cart_status=? where id=?";

		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(2, cart3.getId());
			pstm.setString(1, cart3.getStatus());
			pstm.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		List<Cart> list3 = CartDao.changeStatusOfOrder(cart3.getStatus());
		return list3;

	}

	public static List<Cart> deliveredOrder(String string1, String string2, String dateAndTime) {
		String query = "UPDATE cart set delivered_date_time=?,cart_status=? where cart_status=?";

		try {
			pstm = con.prepareStatement(query);
			pstm.setString(1, dateAndTime);
			pstm.setString(3, string1);
			pstm.setString(2, string2);
			pstm.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		List<Cart> list2 = CartDao.changeStatusOfOrder(string2);

		return list2;
	}

}
