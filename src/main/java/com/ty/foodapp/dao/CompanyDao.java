package com.ty.foodapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ty.foodapp.dto.Company;
import com.ty.foodapp.dto.Review;

public class CompanyDao {
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

	public void saveCompany(Company company) {

		String query = "INSERT INTO company VALUES(?,?,?,?,?,?,?)";

		try {
			pstm = con.prepareStatement(query);

			pstm.setInt(1, company.getId());
			pstm.setString(2, company.getName());
			pstm.setString(3, company.getEmail());
			pstm.setLong(4, company.getContact());
			pstm.setInt(5, company.getGstNo());
			pstm.setInt(6, company.getEstablishedYear());
			pstm.setString(7, company.getAbout());

			boolean status = pstm.execute();

			if (status) {
				System.out.println("data added successfully");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void updateCompany(Company company) {

		String query = "UPDATE company set about=? where id=?";

		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(2, company.getId());
			pstm.setString(1, company.getAbout());
			pstm.execute();
//			r4= findByReview(id2);

		

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void findCompanyById(int id1) {
		String query = "select * from company where id=?";
		Company com=new Company();
		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, id1);
			rs = pstm.executeQuery();

			while (rs.next()) {
				
				com.setId(rs.getInt(1));
				com.setName(rs.getString(2));
				com.setEmail(rs.getString(3));
				com.setContact(rs.getLong(4));
				com.setGstNo(rs.getInt(5));
				com.setEstablishedYear(rs.getInt(6));
				com.setAbout(rs.getString(7));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

//		return r2;
	}
	
	public static void findCompanyByGstNo(int gstNo) {
		String query = "select * from company where gst=?";
		Company com=new Company();
		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, gstNo);
			rs = pstm.executeQuery();

			while (rs.next()) {
				
				com.setId(rs.getInt(1));
				com.setName(rs.getString(2));
				com.setEmail(rs.getString(3));
				com.setContact(rs.getLong(4));
				com.setGstNo(rs.getInt(5));
				com.setEstablishedYear(rs.getInt(6));
				com.setAbout(rs.getString(7));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public static void removeCompany(int id4) {
		String query = "DELETE FROM company WHERE id=?";

		try {
			pstm = con.prepareStatement(query);
			pstm.setInt(1, id4);
			pstm.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
