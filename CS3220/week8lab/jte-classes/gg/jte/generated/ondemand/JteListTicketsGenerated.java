package gg.jte.generated.ondemand;
import com.example.week8lab.model.Ticket;
import java.util.*;
@SuppressWarnings("unchecked")
public final class JteListTicketsGenerated {
	public static final String JTE_NAME = "ListTickets.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,2,4,4,6,6,39,39,41,41,41,41,41,41,41,41,42,42,42,43,43,43,44,44,44,45,45,45,46,46,46,47,47,47,49,49,55,55,55,56,56,56,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Ticket> tickets) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "List Tickets", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n    <nav aria-label=\"breadcrumb\">\n        <ol class=\"breadcrumb my-4\">\n            <li class=\"breadcrumb-item\">\n                <a href=\"/tickets\" class=\"text-decoration-none\">Tickets</a>\n            </li>\n        </ol>\n    </nav>\n\n    <a href=\"/tickets/new\" class=\"btn btn-primary\">Create Ticket</a>\n\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <title>List of Tickets</title>\n</head>\n<body>\n<h2>Ticket List</h2>\n<table class=\"table table-bordered table-striped\">\n    <thead>\n    <tr>\n        <th>Ticket Number</th>\n        <th>Category</th>\n        <th>Subject</th>\n        <th>Requester</th>\n        <th>Date</th>\n        <th>Assigned To</th>\n        <th>Status</th>\n    </tr>\n    </thead>\n    <tbody>\n    ");
				for (Ticket ticket : tickets) {
					jteOutput.writeContent("\n        <tr>\n            <td><a href=\"/tickets/");
					jteOutput.setContext("a", "href");
					jteOutput.writeUserContent(ticket.getTicketNum());
					jteOutput.setContext("a", null);
					jteOutput.writeContent("\">");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(ticket.getTicketNum());
					jteOutput.writeContent("</a></td>  ");
					jteOutput.writeContent("\n            <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(ticket.getCategory());
					jteOutput.writeContent("</td>\n            <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(ticket.getSubject());
					jteOutput.writeContent("</td>\n            <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(ticket.getRequester());
					jteOutput.writeContent("</td>\n            <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(ticket.getDate() != null ? ticket.getDate() : "N/A");
					jteOutput.writeContent("</td>\n            <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(ticket.getAssignedTo() == null ? "None" : ticket.getAssignedTo());
					jteOutput.writeContent("</td>\n            <td>");
					jteOutput.setContext("td", null);
					jteOutput.writeUserContent(ticket.getStatus());
					jteOutput.writeContent("</td>\n        </tr>\n    ");
				}
				jteOutput.writeContent("\n    </tbody>\n</table>\n</body>\n</html>\n\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Ticket> tickets = (List<Ticket>)params.get("tickets");
		render(jteOutput, jteHtmlInterceptor, tickets);
	}
}
