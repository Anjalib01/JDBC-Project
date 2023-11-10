package com.ty.foodapp.dto;

import java.util.Scanner;

import com.ty.foodapp.dao.CompanyDao;

public class MidLayer {
	static Scanner sc = new Scanner(System.in);
	static CompanyDao companyDao=new CompanyDao();

	public static void saveCompany() {
		System.out.println("Enter Id");
		int id=sc.nextInt();
		System.out.println("Enter Company Name");
		String name=sc.next();
		System.out.println("Enter Company Email");
		String email=sc.next();
		System.out.println("Enter Company Contact No");
		Long contact=sc.nextLong();
		System.out.println("Enter Company GST No");
		int gstNo=sc.nextInt();
		System.out.println("Enter Company Year of Establiment");
		int year=sc.nextInt();
		System.out.println("Enter Company About");
		String about=sc.nextLine();
		
		Company company=new Company(id,name,email,contact,gstNo,year,about);
		
		companyDao.saveCompany(company);
		
				
	}

}
