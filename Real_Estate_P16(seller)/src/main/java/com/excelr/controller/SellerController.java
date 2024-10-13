package com.excelr.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.excelr.dao.SellerRepository;
import com.excelr.entity.Seller;
import com.excelr.service.SellerService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/seller")
public class SellerController 
{
	@Autowired
    private SellerService sellerServ;
	
	//adding seller
	@PostMapping("/register")
    public ResponseEntity<Seller> registerSeller(@RequestBody Seller seller) 
	{
        Seller register = sellerServ.addSeller(seller);
        return ResponseEntity.status(HttpStatus.CREATED).body(register);
    }
    
	//fetching all
	@GetMapping("/all")
	public ResponseEntity<List<Seller>> getAll()
	{
		List<Seller> list = sellerServ.getAllSeller();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	//fetching single
	@GetMapping("/{id}")
	public ResponseEntity<Seller> get(@PathVariable Long id)
	{
		Seller s1 = sellerServ.getSeller(id);
		return ResponseEntity.status(HttpStatus.OK).body(s1);
	}
}
