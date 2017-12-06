package com.revature.entities;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Recipe {
	@Id
	@Column(name = "recipe_id")
	@SequenceGenerator(name = "recipe_seq", sequenceName = "recipe_seq")
	@GeneratedValue(generator = "recipe_seq", strategy = GenerationType.AUTO)
	private int recipeId;
	
	@Column(name = "recipe_name")
	private String recipeName;
	
	//not sure how we are going to implement
	private int image;
	
	@Column(name = "cooking_time")
	private double cookingTime;
	
	@Column(name = "date_created")
	private Timestamp dateCreated;
	
	private String directions;
	
	private int upvotes;
	
	private int flag;
	
	//A recipe as a level of difficulty
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="difficulty_id")
	private int difficultyId;
		
	//a recipe has a creator/user that created the recipe
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "creator_id")
	private int creatorId;

	public Recipe(int recipeId, String recipeName, int image, double cookingTime, Timestamp dateCreated,
			String directions, int upvotes, int flag, int difficultyId, int creatorId) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.image = image;
		this.cookingTime = cookingTime;
		this.dateCreated = dateCreated;
		this.directions = directions;
		this.upvotes = upvotes;
		this.flag = flag;
		this.difficultyId = difficultyId;
		this.creatorId = creatorId;
	}

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public double getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(double cookingTime) {
		this.cookingTime = cookingTime;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public int getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getDifficultyId() {
		return difficultyId;
	}

	public void setDifficultyId(int difficultyId) {
		this.difficultyId = difficultyId;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + ", image=" + image + ", cookingTime="
				+ cookingTime + ", dateCreated=" + dateCreated + ", directions=" + directions + ", upvotes=" + upvotes
				+ ", flag=" + flag + ", difficultyId=" + difficultyId + ", creatorId=" + creatorId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cookingTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + creatorId;
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + difficultyId;
		result = prime * result + ((directions == null) ? 0 : directions.hashCode());
		result = prime * result + flag;
		result = prime * result + image;
		result = prime * result + recipeId;
		result = prime * result + ((recipeName == null) ? 0 : recipeName.hashCode());
		result = prime * result + upvotes;
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
		Recipe other = (Recipe) obj;
		if (Double.doubleToLongBits(cookingTime) != Double.doubleToLongBits(other.cookingTime))
			return false;
		if (creatorId != other.creatorId)
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (difficultyId != other.difficultyId)
			return false;
		if (directions == null) {
			if (other.directions != null)
				return false;
		} else if (!directions.equals(other.directions))
			return false;
		if (flag != other.flag)
			return false;
		if (image != other.image)
			return false;
		if (recipeId != other.recipeId)
			return false;
		if (recipeName == null) {
			if (other.recipeName != null)
				return false;
		} else if (!recipeName.equals(other.recipeName))
			return false;
		if (upvotes != other.upvotes)
			return false;
		return true;
	}	
	
	
}

