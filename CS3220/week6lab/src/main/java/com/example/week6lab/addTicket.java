package com.example.week6lab;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/addTicket")
public class addTicket extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        User loggedInUser = (User) session.getAttribute("user");
        String requester = loggedInUser.getName();
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form action='addTicket' method='post'>");
        out.println("Category: <select name='category'>");
        out.println("<option value='Software'>Software</option>");
        out.println("<option value='Hardware'>Hardware</option>");
        out.println("<option value='Facilities'>Facilities</option>");
        out.println("</select><br>");

        out.println("Subject: <input type='text' name='subject'><br>");
        out.println("Requester: <input type='text' name='requester'><br>");
        out.println("Date Submitted: <input type='text' name='date'><br>");
        out.println("Assigned To: <input type='text' name='assignedTo'><br>");
        out.println("Status: <input type='text' name='status'><br>");
        out.println("<input type='submit' value='Add Ticket'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Ticket> ticketList = (List<Ticket>) getServletContext().getAttribute("ticketList");
        List<User> userList = (List<User>) getServletContext().getAttribute("userList");

        String requesterName = request.getParameter("requester");
        boolean requesterFound = false;

        for (User user : userList) {
            if (user.getName().equals(requesterName)) {
                requesterFound = true;
                break;
            }
        }


        if (!requesterFound) {
            response.sendRedirect("addTicket");
            return;
        }

        int ticketNum = ticketList.size() + 1;
        String category = request.getParameter("category");
        String subject = request.getParameter("subject");
        String requester = request.getParameter("requester");
        String date = request.getParameter("date");
        String assignedTo = request.getParameter("assignedTo");
        String status = request.getParameter("status");

        Ticket newTicket = new Ticket(ticketNum, category, subject, requester, date, assignedTo, status);
        ticketList.add(newTicket);

        response.sendRedirect("List-Tickets");
    }
}
