package com.example.week8lab.Service;

import com.example.week8lab.model.Ticket;
import com.example.week8lab.Repository.TicketRepository;
import com.example.week8lab.Repository.UserRepository;
import com.example.week8lab.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    // Get all tickets from the database
    public Iterable<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Get a ticket by ticket number (ticketNum)
    public Ticket getTicketByNumber(Long ticketNum) {
        return ticketRepository.findById(ticketNum).orElse(null);
    }

    // Save a new ticket
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
