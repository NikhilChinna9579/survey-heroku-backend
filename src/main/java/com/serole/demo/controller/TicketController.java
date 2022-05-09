package com.serole.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serole.demo.Dao.TicketDao;
import com.serole.demo.model.Ticket;

@RestController

public class TicketController {
	@Autowired
	private TicketDao dao;
	
	@PostMapping("/test")
	public String bookTicket(@RequestBody Ticket tickets) {
		dao.save(tickets);
		return "ticket booked:";
	}
	@GetMapping("/gettickets")
	public List<Ticket> getTickets(){
		
		return (List<Ticket>)dao.findAll();
	}

     /*@PutMapping("/update")
	public String updaeteTicket(Ticket ticket,  int id) {
		dao.update(id);
	return "ticket updated:";*/

}
