package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.PropertyRepository;
import com.excelr.entity.Property;

@Service
public class PropertyService 
{
	@Autowired
    private PropertyRepository propertyRepo;

	//adding property
    public Property addProperty(Property property) 
    {
        return propertyRepo.save(property);
    }
    
    //fetching all properties
    public List<Property> getAllProp() 
    {
        return propertyRepo.findAll();
    }
    
    //fetching single property
  	public Property getProperty(Long id)
  	{
  		return propertyRepo.findById(id).get();
  	}
}
