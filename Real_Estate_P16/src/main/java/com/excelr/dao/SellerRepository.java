package com.excelr.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.excelr.entity.Seller;

@EnableJpaRepositories
public interface SellerRepository extends JpaRepository<Seller, Long>
{
	Optional<Seller> findByEmail(String email);
}
