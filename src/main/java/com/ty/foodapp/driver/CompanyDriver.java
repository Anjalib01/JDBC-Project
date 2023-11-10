package com.ty.foodapp.driver;

import java.util.Scanner;

import com.ty.foodapp.dto.MidLayer;

public class CompanyDriver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("Enter The Option");
			System.out.println("1: Save Company");
			System.out.println("2: Update Company");
			System.out.println("3: Find By Company Id");
			System.out.println("4: Find By Company GSTNO");
			System.out.println("5: Delete Company");
			System.out.println("6: Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				MidLayer.saveCompany();
				break;

			}

		}
	}

}
