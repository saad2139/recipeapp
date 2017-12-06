package com.revature.entities;

import javax.persistence.*;


@Entity
@Table(name = "difficulty")
public class Difficulty {
	@Id
	@Column(name="difficulty_id")
	private int id;
	
	private String difficulty_level;

	public Difficulty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Difficulty(int id, String difficulty_level) {
		super();
		this.id = id;
		this.difficulty_level = difficulty_level;
	}

	@Override
	public String toString() {
		return "Difficulty [id=" + id + ", difficulty_level=" + difficulty_level + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((difficulty_level == null) ? 0 : difficulty_level.hashCode());
		result = prime * result + id;
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
		Difficulty other = (Difficulty) obj;
		if (difficulty_level == null) {
			if (other.difficulty_level != null)
				return false;
		} else if (!difficulty_level.equals(other.difficulty_level))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDifficulty_level() {
		return difficulty_level;
	}

	public void setDifficulty_level(String difficulty_level) {
		this.difficulty_level = difficulty_level;
	}
	

}
