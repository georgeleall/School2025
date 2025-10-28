package com.example.week8lab.Controller;

import com.example.week8lab.model.Ticket;
import com.example.week8lab.model.Comment;
import com.example.week8lab.Service.TicketService;
import com.example.week8lab.Service.UserService;
import com.example.week8lab.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    // List all tickets
    @GetMapping
    public String listTickets(Model model) {
        Iterable<Ticket> tickets = ticketService.getAllTickets();  // Get all tickets from the database
        model.addAttribute("tickets", tickets);
        return "ListTickets";  // Render the ListTickets.jte template
    }

    // Show the form to create a new ticket
    @GetMapping("/new")
    public String showCreateTicketForm() {
        return "addTicket";  // Return the addTicket.jte template
    }

    // Create a new ticket
    @PostMapping("/new")
    public String createTicket(@RequestParam String category, @RequestParam String subject,
                               @RequestParam(required = false) String date,
                               @RequestParam(required = false) String status, HttpSession session) {

        // Get the currently logged-in user
        User loggedInUser = (User) session.getAttribute("user");

        // If no date is provided, set the current date
        if (date == null || date.isEmpty()) {
            date = java.time.LocalDate.now().toString();  // Set current date if not provided
        }

        // Set the status to 'Open' if not provided
        if (status == null || status.isEmpty()) {
            status = "Open";
        }

        // Query the database to get a list of users (assuming you have a UserService)
        List<User> users = userService.getAllUsers();  // This fetches all users from the database

        // If there are users available, assign a random technician to the ticket
        String assignedTo = "None"; // Default value
        if (!users.isEmpty()) {
            Random random = new Random();
            List<User> technicians = users.stream()
                    .filter(user -> user.getRole() == User.Role.TECHNICIAN)
                    .toList(); // Filter only technicians
            if (!technicians.isEmpty()) {
                User randomTechnician = technicians.get(random.nextInt(technicians.size())); // Select a random technician
                assignedTo = randomTechnician.getName(); // Assign the technician
            } else {
                return "error"; // No technicians available
            }
        } else {
            return "error"; // No users found
        }

        // Use the Ticket constructor with the date and status automatically set
        Ticket newTicket = new Ticket(null, category, subject, loggedInUser.getName(), date, assignedTo, status);
        ticketService.saveTicket(newTicket);  // Save the new ticket to the database

        return "redirect:/tickets";  // Redirect to the list of tickets after creating
    }

    // Add a comment to a ticket
    @PostMapping("/{ticketNum}/comment")
    public String addComment(@PathVariable Long ticketNum, @RequestParam("author") String author,
                             @RequestParam("content") String content) {
        Ticket ticket = ticketService.getTicketByNumber(ticketNum);  // Find the ticket by ticketNum
        if (ticket != null) {
            Comment newComment = new Comment(author, content, new java.util.Date().toString());  // Create a new comment
            newComment.setTicket(ticket);  // Link the comment to the ticket
            ticket.addComment(newComment);  // Add the comment to the ticket's comment list
            ticketService.saveTicket(ticket);  // Save the updated ticket with the new comment
        }
        return "redirect:/tickets/" + ticketNum;  // Redirect back to the ticket details page
    }

    // View a specific ticket by ticketNum
    @GetMapping("/{ticketNum}")
    public String viewTicket(@PathVariable Long ticketNum, Model model, HttpSession session) {
        Ticket ticket = ticketService.getTicketByNumber(ticketNum);  // Get the ticket from the database
        User loggedInUser = (User) session.getAttribute("user");  // Get the logged-in user from the session
        if (ticket != null) {
            model.addAttribute("ticket", ticket);  // Pass the ticket to the view
            model.addAttribute("loggedInUser", loggedInUser);  // Pass the logged-in user to the view
            return "viewTicket";  // Render the viewTicket.jte template
        }
        return "redirect:/tickets";  // Redirect back to tickets list if the ticket is not found
    }


    @PostMapping("/{ticketNum}/close")
    public String closeTicket(@PathVariable Long ticketNum) {
        Ticket ticket = ticketService.getTicketByNumber(ticketNum);
        if (ticket != null && (ticket.getStatus().equals("Open") || ticket.getStatus().equals("Assigned"))) {
            ticket.setStatus("Closed");  // Close the ticket
            ticketService.saveTicket(ticket);
        }
        return "redirect:/tickets/" + ticketNum;  // Redirect to the ticket's details page
    }

    @PostMapping("/{ticketNum}/assign")
    public String assignTicket(@PathVariable Long ticketNum, @RequestParam String assignedTo) {
        Ticket ticket = ticketService.getTicketByNumber(ticketNum);
        if (ticket != null && !assignedTo.isEmpty()) {
            ticket.setAssignedTo(assignedTo);
            ticketService.saveTicket(ticket);
        }
        return "redirect:/tickets/" + ticketNum;  // Redirect to the ticket's details page
    }

}
