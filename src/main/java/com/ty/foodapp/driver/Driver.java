package com.ty.foodapp.driver;

import java.util.List;
import java.util.Scanner;

import com.ty.foodapp.dao.ReviewDao;
import com.ty.foodapp.dto.Review;

public class Driver {
	public static void main(String[] args) {
		ReviewDao dao = new ReviewDao();

		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("Enter The Option");
			System.out.println("1: Save Review");
			System.out.println("2: Update Review");
			System.out.println("3: Find By Review Id");
			System.out.println("4: Find All Reviews");
			System.out.println("5: Delete Review");
			System.out.println("6: Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter review Id");
				int id1 = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter user name");
				String user1 = sc.nextLine();
				sc.nextLine();
				System.out.println("Enter review description");
				String description1 = sc.nextLine();
				System.out.println("Enter review ratting");
				int ratting1 = sc.nextInt();

				Review review1 = ReviewDao.saveReview(id1, user1, description1, ratting1);
				System.out.println(review1);
				break;
			case 2:
				System.out.println("Enter id");
				int id2 = sc.nextInt();
				System.out.println("Enter updated description");
				String description2 = sc.next();

				Review review2 = ReviewDao.updateReview(id2, description2);
				System.out.println(review2);

				break;
			case 3:
				System.out.println("Enter Id");
				int id3 = sc.nextInt();
				Review review3 = ReviewDao.findByReview(id3);
				System.out.println(review3);
				break;
			case 4:
				List<Review> list1 = ReviewDao.findAllReview();
				for (Review r : list1) {
					System.out.println(r);
				}

				break;
			case 5:
				System.out.println("Enter Id");
				int id4 = sc.nextInt();
				ReviewDao.deleteReview(id4);
				break;
			case 6:
				return;

			}
		}
	}

}
