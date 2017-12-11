package com.revature.entities;

import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name = "user_id")
    @SequenceGenerator(name = "userid_seq", sequenceName = "user_id_seq")
    @GeneratedValue(generator = "userid_seq", strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;
    
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "subscriber_publisher", joinColumns = @JoinColumn(name="subscriber_id"), inverseJoinColumns = @JoinColumn(name = "publisher_id"))
    private Set<User> following_list;
    
    @OneToMany(mappedBy="creator", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Recipe> recipesList;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String username, String password, String email, String first_name, String last_name, Role role,
			Set<User> following_list, Set<Recipe>recipeList) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
		this.following_list = following_list;
		this.recipesList = recipeList;
	}


	


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", first_name=" + first_name + ", last_name=" + last_name + ", role=" + role + ", following_list="
				+ following_list + ", recipesList=" + recipesList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((following_list == null) ? 0 : following_list.hashCode());
		result = prime * result + id;
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((recipesList == null) ? 0 : recipesList.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (following_list == null) {
			if (other.following_list != null)
				return false;
		} else if (!following_list.equals(other.following_list))
			return false;
		if (id != other.id)
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (recipesList == null) {
			if (other.recipesList != null)
				return false;
		} else if (!recipesList.equals(other.recipesList))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	public Set<Recipe> getRecipesList() {
		return recipesList;
	}


	public void setRecipesList(Set<Recipe> recipesList) {
		this.recipesList = recipesList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Set<User> getFollowing_list() {
		return following_list;
	}


	public void setFollowing_list(Set<User> following_list) {
		this.following_list = following_list;
	}
}
 