package com.revature.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class Role {
    @Id
    @Column(name = "role_id")
    private int id;
    
    private String role_name;
}
