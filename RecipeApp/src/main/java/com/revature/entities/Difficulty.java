package com.revature.entities;

import javax.persistence.*;


@Entity
@Table(name = "difficulty")
public class Difficulty {
	@Id
	@Column(name="difficulty_id")
	private int id;
	
	private String difficulty_level;
	

}
