package com.excelr.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.SellerRepository;
import com.excelr.entity.Seller;

@Service
public class SellerService
{
	@Autowired
    private SellerRepository sellerRepo;
	
	//adding seller
	public Seller addSeller(Seller seller)
	{
		return sellerRepo.save(seller);
	}
	
	//fetching all
	public List<Seller> getAllSeller()
	{
		return sellerRepo.findAll();
	}
	
	//fetching single
	public Seller getSeller(Long id)
	{
		return sellerRepo.findById(id).get();
	}
}
