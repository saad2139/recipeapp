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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

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
    @JoinTable(name = "user_following_list", joinColumns = @JoinColumn(name="subscriber_id"), inverseJoinColumns = @JoinColumn(name = "publisher_id"))
    private Set<User> following_list;
}
  
