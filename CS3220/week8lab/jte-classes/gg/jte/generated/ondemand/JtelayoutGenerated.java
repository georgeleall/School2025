package gg.jte.generated.ondemand;
import gg.jte.Content;
import java.lang.String;
@SuppressWarnings("unchecked")
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,12,12,12,12,22,28,34,45,45,45,57,57,57,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, Content content) {
		jteOutput.writeContent("\n\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\n    <link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\">\n    <script src=\"/js/bootstrap.bundle.min.js\" defer></script>\n</head>\n<body>\n\n<div class=\"container-xl px-3\">\n\n    <nav class=\"navbar navbar-expand-lg bg-body-tertiary\">\n        <div class=\"container-xl\">\n            ");
		jteOutput.writeContent("\n            <a class=\"navbar-brand\" href=\"#\">\n                <img src=\"/images/customer-support.png\" alt=\"Logo\" width=\"30\" height=\"24\" class=\"d-inline-block align-text-top\">\n                MyTickets\n            </a>\n\n            ");
		jteOutput.writeContent("\n            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\"\n                    aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n                <span class=\"navbar-toggler-icon\"></span>\n            </button>\n\n            ");
		jteOutput.writeContent("\n            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n                <div class=\"navbar-nav\">\n                    <a class=\"nav-link\" href=\"#\">Tickets</a>\n                    <a class=\"nav-link\" href=\"#\">Users</a>\n                    <a class=\"nav-link\" href=\"/\">Logout</a>\n                </div>\n            </div>\n        </div>\n    </nav>\n\n    ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n</div>\n\n</body>\n<footer class=\"text-center text-muted mt-4\">\n    <p class=\"mb-1 lh-sm small\">Copyright &copy; MyTickets 2025</p>\n    <p class=\"mb-0 lh-sm small\">\n        Customer Service icon is created by\n        <a href=\"https://www.flaticon.com/authors/freepik\" class=\"text-secondary\">Freepik</a> from\n        <a href=\"https://www.flaticon.com/\" class=\"text-secondary\">Flaticon</a>\n    </p>\n</footer>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, title, content);
	}
}
