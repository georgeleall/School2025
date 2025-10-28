@import com.example.week8lab.model.Ticket
@import java.util.*
@param List<Ticket> tickets

@template.layout(
title = "List Tickets",
content = @`

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb my-4">
            <li class="breadcrumb-item">
                <a href="/tickets" class="text-decoration-none">Tickets</a>
            </li>
        </ol>
    </nav>

    <a href="/tickets/new" class="btn btn-primary">Create Ticket</a>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Tickets</title>
</head>
<body>
<h2>Ticket List</h2>
<table class="table table-bordered table-striped">
    <thead>
    <tr>
        <th>Ticket Number</th>
        <th>Category</th>
        <th>Subject</th>
        <th>Requester</th>
        <th>Date</th>
        <th>Assigned To</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    @for(Ticket ticket : tickets)
        <tr>
            <td><a href="/tickets/${ticket.getTicketNum()}">${ticket.getTicketNum()}</a></td>  <!-- Ensure this points to /tickets/{ticketNum} -->
            <td>${ticket.getCategory()}</td>
            <td>${ticket.getSubject()}</td>
            <td>${ticket.getRequester()}</td>
            <td>${ticket.getDate() != null ? ticket.getDate() : "N/A"}</td>
            <td>${ticket.getAssignedTo() == null ? "None" : ticket.getAssignedTo()}</td>
            <td>${ticket.getStatus()}</td>
        </tr>
    @endfor
    </tbody>
</table>
</body>
</html>

`)
