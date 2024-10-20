package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Property;
import com.excelr.service.PropertyService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/properties")
public class PropertyController 
{
	@Autowired
	private PropertyService propertyServ;
	
	@PostMapping("/post")
	public ResponseEntity<Property> add(@RequestBody Property property)
	{
		Property p = propertyServ.addProperty(property);		
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Property>> getAll()
	{
		List<Property> list = propertyServ.getAllProperty();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/{propertyId}")
	public ResponseEntity<Property> get(@PathVariable Long propertyId)
	{
		Property p = propertyServ.getProperty(propertyId);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
}
