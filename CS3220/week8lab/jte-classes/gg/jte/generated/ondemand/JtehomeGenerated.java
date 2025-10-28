package gg.jte.generated.ondemand;
@SuppressWarnings("unchecked")
public final class JtehomeGenerated {
	public static final String JTE_NAME = "home.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,0,2,2,19,19,19,19,19,19,19,19};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.ondemand.JteloginlayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Home", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n\n    <h1>Please sign in</h1>\n\n    <form action=\"/login\" method=\"post\">\n        <div class=\"form-group\">\n            <label for=\"email\">Email</label>\n            <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" required>\n        </div>\n        <div class=\"form-group\">\n            <label for=\"password\">Password</label>\n            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" required>\n        </div>\n        <br>\n        <button type=\"submit\" class=\"btn btn-success\">Log In</button>\n    </form>\n\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
