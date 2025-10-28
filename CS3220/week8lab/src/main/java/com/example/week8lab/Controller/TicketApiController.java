package com.example.week8lab.Controller;

import com.example.week8lab.Service.TicketService;
import com.example.week8lab.Service.UserService;
import com.example.week8lab.model.Comment;
import com.example.week8lab.model.Ticket;
import com.example.week8lab.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TicketApiController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}/tickets")
    public ResponseEntity<?> getTicketsByUserId(@PathVariable Long userId) {
        User user = userService.findById(userId);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }

        Iterable<Ticket> allTickets = ticketService.getAllTickets();
        List<Ticket> userTickets = new ArrayList<>();
        for (Ticket ticket : allTickets) {
            if (ticket.getRequester().equals(user.getName())) {
                userTickets.add(ticket);
            }
        }
        return ResponseEntity.ok(userTickets);
    }

    @GetMapping("/tickets/{ticketNum}")
    public ResponseEntity<?> getTicketDetails(@PathVariable Long ticketNum) {
        Ticket ticket = ticketService.getTicketByNumber(ticketNum);
        if (ticket == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ticket not found");
        }

        Map<String, Object> result = new HashMap<>();
        result.put("ticketNumber", ticket.getTicketNum());
        result.put("category", ticket.getCategory());
        result.put("subject", ticket.getSubject());
        result.put("date", ticket.getDate());
        result.put("status", ticket.getStatus());

        // requester details
        User requester = userService.findByName(ticket.getRequester());
        if (requester != null) {
            Map<String, String> reqInfo = new HashMap<>();
            reqInfo.put("name", requester.getName());
            reqInfo.put("email", requester.getEmail());
            reqInfo.put("phone", requester.getPhone());
            result.put("requester", reqInfo);
        }

        // assigned-to details
        if (ticket.getAssignedTo() != null && !ticket.getAssignedTo().isEmpty()) {
            User assignee = userService.findByName(ticket.getAssignedTo());
            if (assignee != null) {
                Map<String, String> asgInfo = new HashMap<>();
                asgInfo.put("name", assignee.getName());
                asgInfo.put("email", assignee.getEmail());
                asgInfo.put("phone", assignee.getPhone());
                result.put("assignedTo", asgInfo);
            }
        }

        // comments
        List<Map<String, Object>> commentsList = new ArrayList<>();
        for (Comment c : ticket.getComments()) {
            Map<String, Object> commentInfo = new HashMap<>();
            commentInfo.put("id", c.getId());
            commentInfo.put("content", c.getContent());
            commentInfo.put("date", c.getDate());
            // author name lookup
            User author = userService.findByName(c.getAuthor());
            commentInfo.put("authorName", author != null ? author.getName() : c.getAuthor());
            commentsList.add(commentInfo);
        }
        result.put("comments", commentsList);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/tickets")
    public ResponseEntity<?> createTicket(@RequestBody Ticket ticket) {
        // validate
        if (ticket.getCategory() == null || ticket.getCategory().isEmpty()
                || ticket.getSubject() == null || ticket.getSubject().isEmpty()
                || ticket.getRequester() == null || ticket.getRequester().isEmpty()
                || ticket.getStatus() == null || ticket.getStatus().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Missing required fields: category, subject, requester, and status are mandatory.");
        }
        // default date
        if (ticket.getDate() == null || ticket.getDate().isEmpty()) {
            ticket.setDate(LocalDate.now().toString());
        }
        Ticket created = ticketService.saveTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PostMapping("/tickets/{ticketNum}/comments")
    public ResponseEntity<?> addCommentToTicket(
            @PathVariable Long ticketNum,
            @RequestBody Comment comment) {

        Ticket ticket = ticketService.getTicketByNumber(ticketNum);
        if (ticket == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ticket not found");
        }
        // validate
        if (comment.getAuthor() == null || comment.getAuthor().isEmpty()
                || comment.getContent() == null || comment.getContent().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Missing required fields: author and content are mandatory.");
        }
        // default date
        if (comment.getDate() == null || comment.getDate().isEmpty()) {
            comment.setDate(LocalDate.now().toString());
        }
        comment.setTicket(ticket);
        ticket.getComments().add(comment);
        ticketService.saveTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(comment);
    }

    @PutMapping("/tickets/{ticketNum}/assign")
    public ResponseEntity<?> assignTicketApi(
            @PathVariable Long ticketNum,
            @RequestBody Map<String, String> body) {

        Ticket ticket = ticketService.getTicketByNumber(ticketNum);
        if (ticket == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ticket not found");
        }
        String assignedTo = body.get("assignedTo");
        if (assignedTo == null || assignedTo.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Missing assignedTo");
        }
        ticket.setAssignedTo(assignedTo);
        ticketService.saveTicket(ticket);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/tickets/{ticketNum}/close")
    public ResponseEntity<?> closeTicketApi(@PathVariable Long ticketNum) {
        Ticket ticket = ticketService.getTicketByNumber(ticketNum);
        if (ticket == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ticket not found");
        }
        ticket.setStatus("Closed");
        ticketService.saveTicket(ticket);
        return ResponseEntity.ok(ticket);
    }

}
