package com.excelr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Property 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String location;
    private String price;
    private String type;
    private String imageUrl;
    
    private String approved;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    @JsonBackReference
    private Agent agent;

    // Custom setter to accept boolean and set String value
    public void setApproved(boolean isApproved) {
        this.approved = isApproved ? "Approved" : "Not Approved";
    }

    // Getter to return the string value
    public String getApproved() {
        return approved;
    }
}
