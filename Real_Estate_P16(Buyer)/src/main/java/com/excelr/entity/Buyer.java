package com.excelr.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Buyer 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyerId;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "buyer_bookmarked_properties",  // Join table name
            joinColumns = @JoinColumn(name = "buyerId"),  // Column in join table referring to Buyer
            inverseJoinColumns = @JoinColumn(name = "propertyId")  // Column in join table referring to Property
        )
    private List<Property> bookmarkedProperties = new ArrayList();
	    
}
