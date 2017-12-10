package com.revature.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	
	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recipes;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int recipeId, String categoryName, Set<Recipe> recipes) {
		super();
		this.categoryId = recipeId;
		this.categoryName = categoryName;
		this.recipes = recipes;
	}
	public Category(int recipeId, String categoryName) {
		super();
		this.categoryId = recipeId;
		this.categoryName = categoryName;
	}
	public int getRecipeId() {
		return categoryId;
	}

	public void setRecipeId(int recipeId) {
		this.categoryId = recipeId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + categoryId;
		result = prime * result + ((recipes == null) ? 0 : recipes.hashCode());
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
		Category other = (Category) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (categoryId != other.categoryId)
			return false;
		if (recipes == null) {
			if (other.recipes != null)
				return false;
		} else if (!recipes.equals(other.recipes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", recipes=" + recipes + "]";
	}
	
	
}
