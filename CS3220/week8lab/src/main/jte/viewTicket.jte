@import com.example.week8lab.model.Ticket
@import com.example.week8lab.model.Comment
@import com.example.week8lab.model.User

@param Ticket ticket
@param User loggedInUser

@template.layout(
title = "View Ticket",
content = @`

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb my-4">
            <li class="breadcrumb-item">
                <a href="/tickets" class="text-decoration-none">Tickets</a>
            </li>
            <li class="breadcrumb-item active" aria-current="page">Ticket #${ticket.getTicketNum()}</li>
        </ol>
    </nav>

    <div class="container">
        <h2>Ticket #${ticket.getTicketNum()}</h2>
        <p><strong>Category:</strong> ${ticket.getCategory()}</p>
        <p><strong>Subject:</strong> ${ticket.getSubject()}</p>
        <p><strong>Requester:</strong> ${ticket.getRequester()}</p>
        <p><strong>Date Submitted:</strong> ${ticket.getDate() != null ? ticket.getDate() : "N/A"}</p>
        <p><strong>Assigned To:</strong><span id="assigned-to">
        ${ticket.getAssignedTo() != null ? ticket.getAssignedTo() : "None"}</span></p>
        <p><strong>Status:</strong><span id="ticket-status">${ticket.getStatus()}</span></p>

        <hr>
        <h3>Comments</h3>
        <ul id="comments-list" class="list-group">
            @for(Comment comment : ticket.getComments())
                <li class="list-group-item">
                    <strong>${comment.getAuthor()}</strong> - ${comment.getDate()}<br>
                    ${comment.getContent()}
                </li>
            @endfor
        </ul>

        <hr>

        <script>
            async function closeTicket(ticketNum) {
                const res = await fetch('/api/tickets/' + ticketNum + '/close', {
                    method: 'PUT'
                });
                if (res.ok) {
                    const data = await res.json();
                    document.getElementById('ticket-status').textContent = data.status;
                } else {
                    alert('Error closing ticket');
                }
            }

            async function assignTechnician(ticketNum) {
                const assignedTo = document.getElementById('assign-input').value;
                const res = await fetch('/api/tickets/' + ticketNum + '/assign', {
                    method: 'PUT',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ assignedTo: assignedTo })
                });
                if (res.ok) {
                    const data = await res.json();
                    document.getElementById('assigned-to').textContent = data.assignedTo;
                } else {
                    alert('Error assigning technician');
                }
            }

            async function addComment(ticketNum) {
                const author  = document.getElementById('comment-author').value;
                const content = document.getElementById('comment-content').value;
                const res = await fetch('/api/tickets/' + ticketNum + '/comments', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ author: author, content: content })
                });
                if (res.ok) {
                    const comment = await res.json();
                    const li = document.createElement('li');
                    li.classList.add('list-group-item');
                    li.textContent = comment.author + ' — ' + comment.date + ': ' + comment.content;
                    document.getElementById('comments-list').appendChild(li);
                    document.getElementById('comment-content').value = '';
                } else {
                    alert('Error adding comment');
                }
            }
        </script>


        <!-- Show "Close Ticket" button only if the logged-in user is a technician and the ticket is open or assigned -->
        @if(loggedInUser != null && loggedInUser.getRole().name().equals("TECHNICIAN") && (ticket.getStatus().equals("Open") || ticket.getStatus().equals("Assigned")))
            <button type="button"
                    class="btn btn-danger"
                    onclick="closeTicket(${ticket.getTicketNum()})">
                Close Ticket
            </button>
        @endif

        <!-- Show "Assign Ticket" button only if the logged-in user is a technician and the ticket is unassigned or assigned to someone else -->
        @if(loggedInUser != null && loggedInUser.getRole().name().equals("TECHNICIAN") && (ticket.getStatus().equals("Open") || ticket.getStatus().equals("Assigned")))
            <div class="mt-3">
                <label for="assign-input">Assign to Technician</label>
                <select
                        id="assign-input"
                        class="form-control">
                    <option value="" disabled selected>Select technician</option>
                    <option value="John">John</option>
                    <option value="Jane">Jane</option>
                </select>
                <button
                        type="button"
                        class="btn btn-primary mt-2"
                        onclick="assignTechnician(${ticket.getTicketNum()})">
                    Assign Ticket
                </button>
            </div>
        @endif

        <hr>
        @if(loggedInUser != null && !ticket.getStatus().equals("Closed"))
            <h4>Add a Comment</h4>
            <input
                    id="comment-author"
                    type="hidden"
                    value="${loggedInUser.getName()}" />

            <div class="form-group">
  <textarea
          id="comment-content"
          class="form-control"
          placeholder="Your comment"></textarea>
            </div>
            <button
                    type="button"
                    class="btn btn-primary mt-2"
                    onclick="addComment(${ticket.getTicketNum()})">
                Submit Comment
            </button>

        @else

            <p class="text-muted">Comments cannot be added to a closed ticket.</p>
        @endif

        <hr>
        <a href="/tickets" class="btn btn-secondary">Return to List</a>
    </div>
`)