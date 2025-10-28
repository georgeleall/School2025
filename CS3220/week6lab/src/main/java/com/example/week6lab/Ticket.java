package com.example.week6lab;

public class Ticket {
    private int ticketNum;
    private String category;
    private String subject;
    private String requester;
    private String date;
    private String assignedTo;
    private String status;

    public Ticket(int ticketNum, String category, String subject, String requester,
                  String date, String assignedTo, String status) {
        this.ticketNum = ticketNum;
        this.category = category;
        this.subject = subject;
        this.requester = requester;
        this.date = date;
        this.assignedTo = assignedTo;
        this.status = status;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
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
}
