package com.ty.foodapp.dto;

public class Review {
	private int review_id;
	private String user_name;
	private String review_description;
	private int review_ratting;
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getReview_description() {
		return review_description;
	}
	public void setReview_description(String review_description) {
		this.review_description = review_description;
	}
	public int getReview_rating() {
		return review_ratting;
	}
	public void setReview_rating(int review_rating) {
		this.review_ratting = review_rating;
	}
	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", user_name=" + user_name + ", review_description="
				+ review_description + ", review_rating=" + review_ratting + "]";
	}
	public Review(int review_id, String user_name, String review_description, int review_rating) {
		super();
		this.review_id = review_id;
		this.user_name = user_name;
		this.review_description = review_description;
		this.review_ratting = review_rating;
	}
	public Review() {
		super();
	}
	
	

}
