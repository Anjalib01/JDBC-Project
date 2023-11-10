package com.ty.foodapp.driver;

import java.util.List;
import java.util.Scanner;

import com.ty.foodapp.dao.CartDao;
import com.ty.foodapp.dto.Cart;

public class CartDriver {
	static Scanner sc = new Scanner(System.in);
	static Cart cart = new Cart();
	static String[] list = cart.getStatusList();

	public static void main(String[] args) {

		while (true) {

			System.out.println("Enter The Option");
			System.out.println("1: Create Cart");
			System.out.println("2: Change Status Of Order");
			System.out.println("3: Delivered Order");
			System.out.println("4: Find All Delivered Items");
			System.out.println("5: Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				createCart();
				break;
			case 2:
				changeStatusOfOrder();
				break;
			case 3:
				deliveredOrder();
				break;
			case 4:
				findAllDeliveredItems();
				break;
			case 5:
				return;

			}

		}
	}

	public static void createCart() {
		System.out.println("Enter Id");
		int id = sc.nextInt();
		System.out.println("Enter Date and time");
		String dateAndtime = sc.next();
		System.out.println("Enter Item Info");
		String itemInfo = sc.next();
		System.out.println("Enter quantity");
		int qty = sc.nextInt();

		Cart cart1 = new Cart(id, dateAndtime, itemInfo, qty, list[0], null);

		Cart cart2 = CartDao.CreateCart(cart1);
		System.out.println(cart2);

	}

	public static void changeStatusOfOrder() {
		List<Cart> li = CartDao.changeStatusOfOrder(list[0]);

		for (Cart c : li) {
			System.out.println("Cart [id=" + c.getId() + ", itemInfo= " + c.getItemInfo()+ ", status=" + c.getStatus()+" ]");
		}

		System.out.println("Enter Id to change the status");
		int id1 = sc.nextInt();

		Cart cart3 = new Cart();
		cart3.setId(id1);
		cart3.setStatus(list[1]);

		List<Cart> list4 = CartDao.updateStatus(cart3);
		for (Cart a : list4) {
			System.out.println(a);
		}

	}

	public static void deliveredOrder() {
		System.out.println("Enter Delivered Date And Time");
		String dateAndTime=sc.next();
		List<Cart> list5 = CartDao.deliveredOrder(list[1], list[2],dateAndTime);

		for (Cart c : list5) {
			System.out.println(c);
		}

	}

	private static void findAllDeliveredItems() {
		List<Cart> list6=CartDao.changeStatusOfOrder(list[2]);
		
		for (Cart c : list6) {
			System.out.println(c);
		}

	}

}
