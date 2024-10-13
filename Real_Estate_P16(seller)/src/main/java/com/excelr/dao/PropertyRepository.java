package com.excelr.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.excelr.entity.Property;

@EnableJpaRepositories
public interface PropertyRepository extends JpaRepository<Property, Long> 
{
	
}
