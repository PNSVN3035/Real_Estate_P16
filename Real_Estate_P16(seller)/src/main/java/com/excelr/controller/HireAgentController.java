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

import com.excelr.entity.HireAgent;
import com.excelr.service.HireAgentService;

@RestController
@RequestMapping("/agent")
public class HireAgentController 
{
	@Autowired
	private HireAgentService agentServ;
	
	//adding
	@PostMapping("/post")
	public ResponseEntity<HireAgent> add(@RequestBody HireAgent agent)
	{
		HireAgent a = agentServ.addAgent(agent);
		return ResponseEntity.status(HttpStatus.CREATED).body(a);
	}
	
	//fetching all
	@GetMapping("/all")
	public ResponseEntity<List<HireAgent>> getAll()
	{
		List<HireAgent> a = agentServ.getAllAgent();
		return ResponseEntity.status(HttpStatus.OK).body(a);
	}
	
	//fetching single
	@GetMapping("/{id}")
	public ResponseEntity<HireAgent> get(@PathVariable int id)
	{
		HireAgent a = agentServ.getAgent(id);
		return ResponseEntity.status(HttpStatus.OK).body(a);
	}
}
