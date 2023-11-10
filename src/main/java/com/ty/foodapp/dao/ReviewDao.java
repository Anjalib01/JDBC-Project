package com.ty.foodapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ty.foodapp.dto.Review;

public class ReviewDao {
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

	public static Review saveReview(int reviewId, String userName, String reviewDescription, int reviewRatting) {
		Review review = new Review(reviewId, userName, reviewDescription, reviewRatting);

		String query = "INSERT INTO review VALUES(?,?,?,?)";

		try {
			pstm = con.prepareStatement(query);

			pstm.setInt(1, review.getReview_id());
			pstm.setString(2, review.getUser_name());
			pstm.setString(3, review.getReview_description());
			pstm.setInt(4, review.getReview_rating());

			boolean status = pstm.execute();

			if (status) {
				System.out.println("data added successfully");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return review;

	}

	public static Review updateReview(int id2, String description2) {
//		
		Review r4 = null;

		String query = "UPDATE review set reviewdescription=? where reviewid=?";

		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(2, id2);
			pstm.setString(1, description2);
			pstm.execute();
			r4= findByReview(id2);

//		

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return r4;

	}

	public static Review findByReview(int id3) {

		String query = "select * from review where reviewid=?";
		Review r2 = null;
		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, id3);
			rs = pstm.executeQuery();

			while (rs.next()) {
				r2 = new Review();
				r2.setReview_id(rs.getInt(1));
				r2.setUser_name(rs.getString(2));
				r2.setReview_description(rs.getString(3));
				r2.setReview_rating(rs.getInt(4));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return r2;

	}

	public static List<Review> findAllReview() {
		List<Review> list = new ArrayList<Review>();
		Review r1 = null;
		String query = "select * from review";
		try {
			pstm = con.prepareStatement(query);
			rs = pstm.executeQuery();

			while (rs.next()) {

				r1 = new Review();
				r1.setReview_id(rs.getInt(1));
				r1.setUser_name(rs.getString(2));
				r1.setReview_description(rs.getString(3));
				r1.setReview_rating(rs.getInt(4));

				list.add(r1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;

	}

	public static void deleteReview(int id4) {
		String query = "DELETE FROM review WHERE reviewid=?";

		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, id4);
			pstm.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
