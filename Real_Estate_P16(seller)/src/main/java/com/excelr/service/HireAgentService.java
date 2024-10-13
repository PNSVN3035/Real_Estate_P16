package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.HireAgentRepository;
import com.excelr.entity.HireAgent;

@Service
public class HireAgentService 
{
	@Autowired
	private HireAgentRepository agentRepo;
	
	//adding
	public HireAgent addAgent(HireAgent agent)
	{
		return agentRepo.save(agent);
	}
	
	//fetching all
	public List<HireAgent> getAllAgent()
	{
		return agentRepo.findAll();
	}
	
	//fetching single
	public HireAgent getAgent(int id)
	{
		return agentRepo.findById(id).get();
	}

}
