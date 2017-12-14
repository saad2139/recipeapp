package com.revature.entities;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ingredient")
public class Ingredient {
	@Id
	@Column(name = "ingredient_id")
	@SequenceGenerator(name = "INGREDIENT_SEQ", sequenceName = "INGREDIENT_SEQ")
	@GeneratedValue(generator = "INGREDIENT_SEQ", strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "ingredient_name")
	private String name;

	private String quantity;
	//************8
//	@ManyToMany(mappedBy = "ingredients") //--BEFORE
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)  //cascade all
	@JoinTable(
			name = "recipe_ingredients",
			joinColumns = { @JoinColumn(name = "ingredient_id")},
			inverseJoinColumns = { @JoinColumn (name = "recipe_id")})
	private Set <Recipe> recipes;

	
	public Ingredient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ingredient(int id, String name, String quantity, Set<Recipe> recipes) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.recipes = recipes;
	}
	

	public Ingredient(int id, String name, String quantity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (recipes == null) {
			if (other.recipes != null)
				return false;
		} else if (!recipes.equals(other.recipes))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}
	
	//set recipes used to update the join table
	public void setRecipes(Set<Recipe> recipes) {
//		for(Recipe r : recipes) {
//			if(!r.getIngredients().contains(this)) {
//				r.getIngredients().add(this);
//			}
//		}
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", name=" + name + ", quantity=" + quantity + ", recipes=" +"]";
	}
	
	
}
