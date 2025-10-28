package gg.jte.generated.ondemand;
import com.example.week8lab.model.Ticket;
import com.example.week8lab.model.Comment;
import com.example.week8lab.model.User;
@SuppressWarnings("unchecked")
public final class JteviewTicketGenerated {
	public static final String JTE_NAME = "viewTicket.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,4,4,4,4,7,7,9,9,16,16,16,21,21,21,22,22,22,23,23,23,24,24,24,25,25,25,27,27,27,28,28,28,33,33,35,35,35,35,35,35,36,36,36,38,38,93,94,94,97,97,97,97,100,100,102,103,103,116,116,116,116,120,120,123,123,128,128,128,128,128,128,128,128,128,139,139,139,139,143,143,146,146,151,151,151,151,151,4,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Ticket ticket, User loggedInUser) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "View Ticket", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n    <nav aria-label=\"breadcrumb\">\n        <ol class=\"breadcrumb my-4\">\n            <li class=\"breadcrumb-item\">\n                <a href=\"/tickets\" class=\"text-decoration-none\">Tickets</a>\n            </li>\n            <li class=\"breadcrumb-item active\" aria-current=\"page\">Ticket #");
				jteOutput.setContext("li", null);
				jteOutput.writeUserContent(ticket.getTicketNum());
				jteOutput.writeContent("</li>\n        </ol>\n    </nav>\n\n    <div class=\"container\">\n        <h2>Ticket #");
				jteOutput.setContext("h2", null);
				jteOutput.writeUserContent(ticket.getTicketNum());
				jteOutput.writeContent("</h2>\n        <p><strong>Category:</strong> ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(ticket.getCategory());
				jteOutput.writeContent("</p>\n        <p><strong>Subject:</strong> ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(ticket.getSubject());
				jteOutput.writeContent("</p>\n        <p><strong>Requester:</strong> ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(ticket.getRequester());
				jteOutput.writeContent("</p>\n        <p><strong>Date Submitted:</strong> ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(ticket.getDate() != null ? ticket.getDate() : "N/A");
				jteOutput.writeContent("</p>\n        <p><strong>Assigned To:</strong><span id=\"assigned-to\">\n        ");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(ticket.getAssignedTo() != null ? ticket.getAssignedTo() : "None");
				jteOutput.writeContent("</span></p>\n        <p><strong>Status:</strong><span id=\"ticket-status\">");
				jteOutput.setContext("span", null);
				jteOutput.writeUserContent(ticket.getStatus());
				jteOutput.writeContent("</span></p>\n\n        <hr>\n        <h3>Comments</h3>\n        <ul id=\"comments-list\" class=\"list-group\">\n            ");
				for (Comment comment : ticket.getComments()) {
					jteOutput.writeContent("\n                <li class=\"list-group-item\">\n                    <strong>");
					jteOutput.setContext("strong", null);
					jteOutput.writeUserContent(comment.getAuthor());
					jteOutput.writeContent("</strong> - ");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(comment.getDate());
					jteOutput.writeContent("<br>\n                    ");
					jteOutput.setContext("li", null);
					jteOutput.writeUserContent(comment.getContent());
					jteOutput.writeContent("\n                </li>\n            ");
				}
				jteOutput.writeContent("\n        </ul>\n\n        <hr>\n\n        <script>\n            async function closeTicket(ticketNum) {\n                const res = await fetch('/api/tickets/' + ticketNum + '/close', {\n                    method: 'PUT'\n                });\n                if (res.ok) {\n                    const data = await res.json();\n                    document.getElementById('ticket-status').textContent = data.status;\n                } else {\n                    alert('Error closing ticket');\n                }\n            }\n\n            async function assignTechnician(ticketNum) {\n                const assignedTo = document.getElementById('assign-input').value;\n                const res = await fetch('/api/tickets/' + ticketNum + '/assign', {\n                    method: 'PUT',\n                    headers: { 'Content-Type': 'application/json' },\n                    body: JSON.stringify({ assignedTo: assignedTo })\n                });\n                if (res.ok) {\n                    const data = await res.json();\n                    document.getElementById('assigned-to').textContent = data.assignedTo;\n                } else {\n                    alert('Error assigning technician');\n                }\n            }\n\n            async function addComment(ticketNum) {\n                const author  = document.getElementById('comment-author').value;\n                const content = document.getElementById('comment-content').value;\n                const res = await fetch('/api/tickets/' + ticketNum + '/comments', {\n                    method: 'POST',\n                    headers: { 'Content-Type': 'application/json' },\n                    body: JSON.stringify({ author: author, content: content })\n                });\n                if (res.ok) {\n                    const comment = await res.json();\n                    const li = document.createElement('li');\n                    li.classList.add('list-group-item');\n                    li.textContent = comment.author + ' — ' + comment.date + ': ' + comment.content;\n                    document.getElementById('comments-list').appendChild(li);\n                    document.getElementById('comment-content').value = '';\n                } else {\n                    alert('Error adding comment');\n                }\n            }\n        </script>\n\n\n        ");
				jteOutput.writeContent("\n        ");
				if (loggedInUser != null && loggedInUser.getRole().name().equals("TECHNICIAN") && (ticket.getStatus().equals("Open") || ticket.getStatus().equals("Assigned"))) {
					jteOutput.writeContent("\n            <button type=\"button\"\n                    class=\"btn btn-danger\"\n                    onclick=\"closeTicket(");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(ticket.getTicketNum());
					jteOutput.setContext("button", null);
					jteOutput.writeContent(")\">\n                Close Ticket\n            </button>\n        ");
				}
				jteOutput.writeContent("\n\n        ");
				jteOutput.writeContent("\n        ");
				if (loggedInUser != null && loggedInUser.getRole().name().equals("TECHNICIAN") && (ticket.getStatus().equals("Open") || ticket.getStatus().equals("Assigned"))) {
					jteOutput.writeContent("\n            <div class=\"mt-3\">\n                <label for=\"assign-input\">Assign to Technician</label>\n                <select\n                        id=\"assign-input\"\n                        class=\"form-control\">\n                    <option value=\"\" disabled selected>Select technician</option>\n                    <option value=\"John\">John</option>\n                    <option value=\"Jane\">Jane</option>\n                </select>\n                <button\n                        type=\"button\"\n                        class=\"btn btn-primary mt-2\"\n                        onclick=\"assignTechnician(");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(ticket.getTicketNum());
					jteOutput.setContext("button", null);
					jteOutput.writeContent(")\">\n                    Assign Ticket\n                </button>\n            </div>\n        ");
				}
				jteOutput.writeContent("\n\n        <hr>\n        ");
				if (loggedInUser != null && !ticket.getStatus().equals("Closed")) {
					jteOutput.writeContent("\n            <h4>Add a Comment</h4>\n            <input\n                    id=\"comment-author\"\n                    type=\"hidden\"\n                   ");
					var __jte_html_attribute_0 = loggedInUser.getName();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("input", "value");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("input", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" />\n\n            <div class=\"form-group\">\n  <textarea\n          id=\"comment-content\"\n          class=\"form-control\"\n          placeholder=\"Your comment\"></textarea>\n            </div>\n            <button\n                    type=\"button\"\n                    class=\"btn btn-primary mt-2\"\n                    onclick=\"addComment(");
					jteOutput.setContext("button", "onclick");
					jteOutput.writeUserContent(ticket.getTicketNum());
					jteOutput.setContext("button", null);
					jteOutput.writeContent(")\">\n                Submit Comment\n            </button>\n\n        ");
				} else {
					jteOutput.writeContent("\n\n            <p class=\"text-muted\">Comments cannot be added to a closed ticket.</p>\n        ");
				}
				jteOutput.writeContent("\n\n        <hr>\n        <a href=\"/tickets\" class=\"btn btn-secondary\">Return to List</a>\n    </div>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Ticket ticket = (Ticket)params.get("ticket");
		User loggedInUser = (User)params.get("loggedInUser");
		render(jteOutput, jteHtmlInterceptor, ticket, loggedInUser);
	}
}
