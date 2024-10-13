package com.excelr.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Agent 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String name;
    private String email;
    private String password;
    private String mobileNumber;
    private String dob;
    private String role;
    private String aadharNo;
    private String panNo;
    private String gender;
    
    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Property> properties;	    
}
