package com.revature.entities;

import java.sql.Blob;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Recipe")
public class Recipe {
	@Id
	@Column(name = "recipe_id")
	@SequenceGenerator(name = "recipe_seq", sequenceName = "recipe_seq")
	@GeneratedValue(generator = "recipe_seq", strategy = GenerationType.AUTO)
	private int recipeId;

	@Column(name = "recipe_name")
	private String recipeName;

	private String image;

	@Column(name = "cooking_time")
	private double cookingTime;

	@Column(name = "date_created")
	private Date dateCreated;

	private String directions;

	private int upvotes;

	private int flag;

	// A recipe as a level of difficulty
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "difficulty_id")
	private Difficulty difficulty;

	// Many recipes are created by the user
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User creator;
	
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)  //cascade all
//	@JoinTable(
//			name = "recipe_ingredients",
//			joinColumns = { @JoinColumn(name = "recipe_id")},
//			inverseJoinColumns = { @JoinColumn (name = "ingredient_id")})
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "recipes", cascade = CascadeType.ALL)  //changed
	private Set<Ingredient> ingredients;
	

	@ManyToMany(mappedBy = "recipes", fetch = FetchType.EAGER, cascade = CascadeType.ALL) //currently
//	@ManyToMany 
//	@JoinTable(
//			name = "recipe_categories",
//			joinColumns = { @JoinColumn(name = "recipe_id")},
//			inverseJoinColumns = { @JoinColumn (name = "category_id")})
	private Set<Category> categories;

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Recipe(int recipeId, String recipeName, String image, double cookingTime, Date dateCreated, String directions,
			int upvotes, int flag, Difficulty difficulty, User creator, Set<Ingredient> ingredients,
			Set<Category> categories) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		//this.image = image;
		this.cookingTime = cookingTime;
		this.dateCreated = dateCreated;
		this.directions = directions;
		this.upvotes = upvotes;
		this.flag = flag;
		this.difficulty = difficulty;
		this.creator = creator;
		this.ingredients = ingredients;
		this.categories = categories;
	}

=======
	@ManyToMany (fetch = FetchType.EAGER, cascade = { CascadeType.ALL})
	@JoinTable(
			name = "recipe_categories",
			joinColumns = { @JoinColumn(name = "recipe_id")},
			inverseJoinColumns = { @JoinColumn (name = "category_id")})
	private Set<Category> categories;
>>>>>>> refs/remotes/origin/master

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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(double cookingTime) {
		this.cookingTime = cookingTime;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
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

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
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

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	//join table
	public void setJoinCategories(Set<Category> categories) {
		System.out.println(categories.size());
		if(this.categories.size() > 0) {
		for(Category c : categories) {
			if(!c.getRecipes().contains(this)) {
				c.getRecipes().add(this);
			}
		}
		} else {
		this.categories = categories;
		}
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + ", image=" + image + ", cookingTime="
				+ cookingTime + ", dateCreated=" + dateCreated + ", directions=" + directions + ", upvotes=" + upvotes
				+ ", flag=" + flag + ", difficulty=" + difficulty + ", creator=" + creator + ", ingredients="
				+ ingredients + ", categories=" + categories + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cookingTime);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + ((difficulty == null) ? 0 : difficulty.hashCode());
		result = prime * result + ((directions == null) ? 0 : directions.hashCode());
		result = prime * result + flag;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
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
		if (categories == null) {
			if (other.categories != null)
				return false;
		} else if (!categories.equals(other.categories))
			return false;
		if (Double.doubleToLongBits(cookingTime) != Double.doubleToLongBits(other.cookingTime))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (difficulty == null) {
			if (other.difficulty != null)
				return false;
		} else if (!difficulty.equals(other.difficulty))
			return false;
		if (directions == null) {
			if (other.directions != null)
				return false;
		} else if (!directions.equals(other.directions))
			return false;
		if (flag != other.flag)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
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

	public Recipe(int recipeId, String recipeName, String image, double cookingTime, Date dateCreated,
			String directions, int upvotes, int flag, Difficulty difficulty, User creator, Set<Ingredient> ingredients,
			Set<Category> categories) {
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
		this.ingredients = ingredients;
		this.categories = categories;
	}
	
	

	
}
