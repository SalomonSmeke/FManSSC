import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.FManSSC.dal.*;
import com.FManSSC.model.customer.Customer;

import Fixtures.Customers;

@SuppressWarnings("serial")
public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		demo(response.getWriter());
	}

	public static void main(String... args) throws Exception  {
		String PORT = System.getenv("PORT");
		if (PORT==null) PORT = "8080";
		Server server = new Server(Integer.valueOf(PORT));
		ServletContextHandler ctx = new ServletContextHandler(ServletContextHandler.SESSIONS);
		ctx.setContextPath("/");
		server.setHandler(ctx);
		ctx.addServlet(new ServletHolder(new Main()), "/*");
		server.start();
		server.join();
	}
	
	protected void demo(PrintWriter out){
		Customer cust = Customers.cust0;
		boolean v = cust.verify();
		out.println("Customer Salomon was verified with result: " + v);
		CustomerHibernateDAO custDAO = new CustomerHibernateDAO();
		custDAO.addCustomer(cust);
		Customer retrieved = custDAO.retrieveCustomer(1);
		custDAO.deleteCustomer(retrieved);
		
		out.println("looks good jim!");
	}
}
