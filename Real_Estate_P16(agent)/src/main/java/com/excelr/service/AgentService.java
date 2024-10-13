package com.excelr.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.AgentRepository;
import com.excelr.entity.Agent;

@Service
public class AgentService
{
	@Autowired
    private AgentRepository agentRepo;
	
	//adding agent
	public Agent addAgent(Agent agent)
	{
		return agentRepo.save(agent);
	}
	
	//fetching all
	public List<Agent> getAllAgent()
	{
		return agentRepo.findAll();
	}
	
	//fetching single
	public Agent getAgent(Long id)
	{
		return agentRepo.findById(id).get();
	}
}
