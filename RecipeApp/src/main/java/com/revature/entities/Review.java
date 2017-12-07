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
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Review(int reviewId, String description, int rating) {
		super();
		this.reviewId = reviewId;
		this.description = description;
		this.rating = rating;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + rating;
		result = prime * result + reviewId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (rating != other.rating)
			return false;
		if (reviewId != other.reviewId)
			return false;
		return true;
	}

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

	
	
	
	
}
