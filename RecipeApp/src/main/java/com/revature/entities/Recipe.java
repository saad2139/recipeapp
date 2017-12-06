package com.revature.entities;

import java.sql.Timestamp;

import javax.persistence.*;


@Entity
public class Recipe {
	@Id
	@Column(name = "recipe_id")
	@SequenceGenerator(name = "recipe_seq", sequenceName = "recipe_seq")
	@GeneratedValue(generator = "recipe_seq", strategy = GenerationType.AUTO)
	private int recipeId;

	@Column(name = "recipe_name")
	private String recipeName;

	// not sure how we are going to implement
	private int image;

	@Column(name = "cooking_time")
	private double cookingTime;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	private String directions;

	private int upvotes;

	private int flag;

	// A recipe as a level of difficulty
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "difficulty_id")
	private Difficulty difficulty;

	// a recipe has a creator/user that created the recipe
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User creator;

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recipe(int recipeId, String recipeName, int image, double cookingTime, Timestamp dateCreated,
			String directions, int upvotes, int flag, Difficulty difficulty, User creator) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.image = image;
		this.cookingTime = cookingTime;
		this.dateCreated = dateCreated;
		this.directions = directions;
		this.upvotes = upvotes;
		this.flag = flag;
		this.difficulty = difficulty;
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + ", image=" + image + ", cookingTime="
				+ cookingTime + ", dateCreated=" + dateCreated + ", directions=" + directions + ", upvotes=" + upvotes
				+ ", flag=" + flag + ", difficulty=" + difficulty + ", creator=" + creator + "]";
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

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

}