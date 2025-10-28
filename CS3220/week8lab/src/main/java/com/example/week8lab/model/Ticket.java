package com.example.week8lab.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Tickets")  // Correct table name as per your database
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticketNumber")  // Correct column name
    private Long ticketNum;

    @Column(name="category")
    private String category;

    @Column(name="subject")
    private String subject;

    @Column(name="requestor")
    private String requester;

    @Column(name="date")
    private String date;  // Using String for the date as per your requirement

    @Column(name="assignedTo")
    private String assignedTo;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Comment> comments; // List of comments for each ticket

    // Default constructor for JPA
    public Ticket() {}

    // Constructor with String for date
    public Ticket(Long ticketNum, String category, String subject, String requester,
                  String date, String assignedTo, String status) {
        this.ticketNum = ticketNum;  // Use Long for ticketNum, not int
        this.category = category;
        this.subject = subject;
        this.requester = requester;
        this.date = date;
        this.assignedTo = assignedTo;
        this.status = status;
    }

    // Getter and Setter methods
    public Long getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(Long ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);  // Adds a comment to the ticket
    }
}
