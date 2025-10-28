package gg.jte.generated.ondemand;
import gg.jte.Content;
import java.lang.String;
@SuppressWarnings("unchecked")
public final class JteloginlayoutGenerated {
	public static final String JTE_NAME = "loginlayout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,11,11,11,11,21,35,35,35,39,39,39,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, Content content) {
		jteOutput.writeContent("\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>");
		jteOutput.setContext("title", null);
		jteOutput.writeUserContent(title);
		jteOutput.writeContent("</title>\n    <link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\">\n    <script src=\"/js/bootstrap.bundle.min.js\" defer></script>\n</head>\n<style>\n    body {\n        display: flex;\n        align-items: center;\n        justify-content: center;\n        height: 100vh;\n        background-color: #f8f9fa; ");
		jteOutput.writeContent("\n    }\n    .login-container {\n        width: 100%;\n        max-width: 400px;\n        padding: 2rem;\n        background: white;\n        border-radius: 10px;\n        box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);\n    }\n</style>\n<body>\n\n<div class=\"login-container\">\n    ");
		jteOutput.setContext("div", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n</div>\n\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.get("title");
		Content content = (Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, title, content);
	}
}
