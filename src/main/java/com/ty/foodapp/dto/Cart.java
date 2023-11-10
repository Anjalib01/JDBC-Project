package com.ty.foodapp.dto;

import java.util.Arrays;

public class Cart {
	private int id;
	private String createdDateAndTime;
	private String itemInfo;
	private int quantity;
	private String status;
	private String deliveredDateAndTime = null;

	private String[] statusList = { "Created", "ReadyToDispatch", "Delivered" };

	public Cart(int id, String itemInfo, String status) {
		super();
		this.id = id;
		this.itemInfo = itemInfo;
		this.status = status;
	}

	public String[] getStatusList() {
		return statusList;
	}

	public void setStatusList(String[] statusList) {
		this.statusList = statusList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedDateAndTime() {
		return createdDateAndTime;
	}

	public void setCreatedDateAndTime(String createdDateAndTime) {
		this.createdDateAndTime = createdDateAndTime;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveredDateAndTime() {
		return deliveredDateAndTime;
	}

	public void setDeliveredDateAndTime(String deliveredDateAndTime) {
		this.deliveredDateAndTime = deliveredDateAndTime;
	}

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", createdDateAndTime=" + createdDateAndTime + ", itemInfo=" + itemInfo
				+ ", quantity=" + quantity + ", status=" + status + ", deliveredDateAndTime=" + deliveredDateAndTime
				+ "]";
	}

	public Cart(int id, String createdDateAndTime, String itemInfo, int quantity, String status,
			String deliveredDateAndTime) {
		super();
		this.id = id;
		this.createdDateAndTime = createdDateAndTime;
		this.itemInfo = itemInfo;
		this.quantity = quantity;
		this.status = status;
		this.deliveredDateAndTime = deliveredDateAndTime;
	}
	
	

}
