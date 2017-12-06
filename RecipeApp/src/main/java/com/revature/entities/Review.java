package com.revature.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {
	@Id
	@Column(name="review_id")
	private int reviewId;
	
	private String description;
	private int rating;
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", description=" + description + ", rating=" + rating + "]";
	}
	public Review(int reviewId, String description, int rating) {
		super();
		this.reviewId = reviewId;
		this.description = description;
		this.rating = rating;
	}
	
	
	
	
}
