package com.excelr.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.BuyerRepository;
import com.excelr.dao.PropertyRepository;
import com.excelr.entity.Buyer;
import com.excelr.entity.Property;


@Service
public class BuyerService
{
	@Autowired
    private BuyerRepository buyerRepo;
	
	@Autowired
	private PropertyRepository propertyRepo;
	
	//adding
	public Buyer addbuyer(Buyer buyer)
	{
		return buyerRepo.save(buyer);
	}
	
	//book mark properties
	public Buyer bookmarkProperty(Long buyerId, Long propertyId)
	{
		Buyer b = buyerRepo.findById(buyerId).get();
		Property p = propertyRepo.findById(propertyId).get();
		List<Property> list = b.getBookmarkedProperties();
		list.add(p);
		return buyerRepo.save(b);		
	}
	
	//get all
	public List<Buyer> getAllBuyer()
	{
		return buyerRepo.findAll();
	}
	
	//single
	public Buyer getBuyer(Long buyerId)
	{
		return buyerRepo.findById(buyerId).get();
	}    
}
