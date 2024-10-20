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
	
	//adding
	public Property addProperty(Property property)
	{
		return propertyRepo.save(property);
	}
	
	//get all
	public List<Property> getAllProperty()
	{
		return propertyRepo.findAll();
	}
	
	//single
	public Property getProperty(Long propertyId)
	{
		return propertyRepo.findById(propertyId).get();
	}
}
