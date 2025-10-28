package com.example.week6lab;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "ListTickets", value = "/List-Tickets", loadOnStartup = 1)
public class ListTickets extends HttpServlet {
    private List<Ticket> ticketList;

    public void init() {
        User Josh =  new User();
        Josh.setName("Josh");
        Josh.setEmail("josh@example.com");
        Josh.setPassword("abcd");
        User Eva = new User();
        Eva.setName("Eva");
        Eva.setEmail("eva@example.com");
        Eva.setPassword("1234");
        User John = new User();
        John.setName("John");
        John.setEmail("john@example.com");
        John.setPassword("defg");

        List<User> userList = new ArrayList<>();
        userList.add(Josh);
        userList.add(Eva);
        userList.add(John);

        getServletContext().setAttribute("userList", userList);

        Ticket ticket1 = new Ticket(1, "Software", "Tomcat on CS3 Stopped", Josh.getName(), "2025-02-13", "None", "Open");
        Ticket ticket2 = new Ticket(2, "Hardware", "Printer problem in ECST mail room", Eva.getName(), "2025-02-14", "John", "Closed");

        this.ticketList = new ArrayList<>();
        ticketList.add(ticket1);
        ticketList.add(ticket2);

        getServletContext().setAttribute("ticketList", ticketList);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        response.setContentType("text/html");
        List<Ticket> ticketList = (List<Ticket>) getServletContext().getAttribute("ticketList");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Tickets" + "</h1>");
        out.println("<p><a href='addTicket'>Create a Ticket</a></p>");
        out.println("<p><a href='LogoutServlet'>Logout</a></p>");
        out.println("<table border='1'>");
        out.println("<tr><th>Number</th><th>Category</th><th>Subject</th><th>Requester</th><th>Date Submitted</th><th>Assigned To</th><th>Status</th></tr>");

        for (Ticket ticket : ticketList) {
            out.println("<tr>");
            out.println("<td>" + ticket.getTicketNum() + "</td>");
            out.println("<td>" + ticket.getCategory() + "</td>");
            out.println("<td>" + ticket.getSubject() + "</td>");
            out.println("<td>" + ticket.getRequester() + "</td>");
            out.println("<td>" + ticket.getDate() + "</td>");
            out.println("<td>" + ticket.getAssignedTo() + "</td>");
            out.println("<td>" + ticket.getStatus() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }



    public void destroy() {
    }
}