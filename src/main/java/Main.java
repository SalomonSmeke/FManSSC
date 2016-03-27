import java.io.IOException;

import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;

public class Main extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.getWriter().println("hi");;
		
	}
	
	public static void main(String... args)  {
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
		
	}
}
