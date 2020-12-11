package com.codedictator.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedictator.model.Ticket;
import com.codedictator.repository.TicketDAO;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketDAO dao;

	@GetMapping("/getTickets")
	public List<Ticket> getTickets() {
		// logic to return list of ticket obj
		return dao.findAll();
	}

	@PostMapping("/addTicke")
	public String bookTicket(@RequestBody Ticket tickets) {
		dao.save(tickets);
		return "Ticket Booked: " + LocalDateTime.now();
	}
}
// select 
// ticket0_.ticket_id as ticket_i1_0_, ticket0_.cost as cost2_0_, ticket0_.type as type3_0_, ticket0_.owner as owner4_0_ 
// from 
// ticket_counter ticket0_

// SELECT * FROM ticket_counter