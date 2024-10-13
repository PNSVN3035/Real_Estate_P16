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

import com.excelr.dao.AgentRepository;
import com.excelr.entity.Agent;
import com.excelr.service.AgentService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/agent")
public class AgentController 
{
	@Autowired
    private AgentService agentServ;
	
	//adding agent
	@PostMapping("/register")
    public ResponseEntity<Agent> registerSeller(@RequestBody Agent agent) 
	{
        Agent register = agentServ.addAgent(agent);
        return ResponseEntity.status(HttpStatus.CREATED).body(register);
    }
    
	//fetching all
	@GetMapping("/all")
	public ResponseEntity<List<Agent>> getAll()
	{
		List<Agent> list = agentServ.getAllAgent();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	//fetching single
	@GetMapping("/{id}")
	public ResponseEntity<Agent> get(@PathVariable Long id)
	{
		Agent s1 = agentServ.getAgent(id);
		return ResponseEntity.status(HttpStatus.OK).body(s1);
	}
}
