package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.dao.PropertyRepository;
import com.excelr.entity.Property;
import com.excelr.service.PropertyService;

@RestController
@RequestMapping("/property")
public class PropertyController 
{
	@Autowired
    private PropertyService propertyServ;

	//adding property
    @PostMapping("/post")
    public ResponseEntity<Property> add(@RequestBody Property property) 
    {
        Property p1 = propertyServ.addProperty(property);
        return ResponseEntity.status(HttpStatus.CREATED).body(p1);
    }

    //fetching all properties
    @GetMapping("/all")
    public ResponseEntity<List<Property>> getAll() 
    {
    	List<Property> p1 = propertyServ.getAllProp();
        return ResponseEntity.status(HttpStatus.OK).body(p1);
    }
    
    //fetching single property
    @GetMapping("/{id}")
    public ResponseEntity<Property> get(@PathVariable Long id)
    {
    	Property p1 = propertyServ.getProperty(id);
    	return ResponseEntity.status(HttpStatus.OK).body(p1);
    }
}
