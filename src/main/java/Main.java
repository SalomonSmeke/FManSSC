import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.FManSSC.dal.*;
import com.FManSSC.model.backbones.Address;
import com.FManSSC.model.customer.Customer;

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
		Address address = new Address();
		address.setId(1);
		address.setStreetNo(0);
		address.setStreet("W. Granville");
		address.setZip("60660");
		address.setCity("Chicago");
		address.setState("Illinois");
		Customer cust = new Customer();
		cust.setId(1);
		cust.setFirst("Salomon");
		cust.setLast("Smeke");
		cust.setBody("8135023882");
		cust.setExtension("1");
		cust.setEmail("ssmeke@luc.edu");
		cust.setCustAddress(address);
		boolean v = cust.verify();
		out.println("Customer Salomon was verified with result: " + v);
		CustomerHibernateDAO custDAO = new CustomerHibernateDAO();
		custDAO.addCustomer(cust);
		out.println("Not implemented");
	}
}
