package com.excelr.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.excelr.entity.Buyer;

@EnableJpaRepositories
public interface BuyerRepository extends JpaRepository<Buyer, Long>
{
	
}
