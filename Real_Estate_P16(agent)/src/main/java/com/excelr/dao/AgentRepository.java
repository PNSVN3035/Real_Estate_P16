package com.excelr.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.excelr.entity.Agent;

@EnableJpaRepositories
public interface AgentRepository extends JpaRepository<Agent, Long>
{
	Optional<Agent> findByEmail(String email);
}
