package com.excelr.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

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

import com.excelr.dao.BuyerRepository;
import com.excelr.entity.Buyer;
import com.excelr.entity.Property;
import com.excelr.service.BuyerService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/buyer")
public class BuyerController 
{
	@Autowired
    private BuyerService buyerServ;

	@PostMapping("/post")
    public ResponseEntity<Buyer> add(@RequestBody Buyer buyer) 
	{
		Buyer b = buyerServ.addbuyer(buyer);
        return ResponseEntity.status(HttpStatus.CREATED).body(b);
    }
	
	@PostMapping("/buyer/{buyerId}/bookmark/property/{propertyId}")
	public ResponseEntity<Buyer> bookmark(@PathVariable Long buyerId, @PathVariable Long propertyId)
	{
		Buyer b = buyerServ.bookmarkProperty(buyerId, propertyId);
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}

    @GetMapping("/all")
    public ResponseEntity<List<Buyer>> getAll() 
    {
        List<Buyer> list = buyerServ.getAllBuyer();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    
    @GetMapping("/{buyerId}")
    public ResponseEntity<Buyer> get(@PathVariable Long buyerId) 
    {
        Buyer b = buyerServ.getBuyer(buyerId);
        return ResponseEntity.status(HttpStatus.OK).body(b);
    }
}
