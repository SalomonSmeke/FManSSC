import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.FManSSC.dal.*;
import com.FManSSC.model.backbones.Address;
import com.FManSSC.model.customer.Customer;

import Fixtures.Customers;

@SuppressWarnings("serial")
public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.println("Greetings! Initializing AppContext for beans.");
		out.println();
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		out.println("Success!");
		out.println();
		out.println("Testing objects with POJOS");
		demoPOJO(out,"  ");
		out.println();
		out.println("Success!");
		out.println();
		out.println("Testing objects with Beans!");
		demoBeans(out,"  ",context);
		out.println();
		out.println("Success!");
		out.println();
		out.println("Testing database with Mixed objects");
		demoDB(out,"  ",context);
		out.println();
		out.println("Success!");
		out.println();
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
	
	protected void demoPOJO(PrintWriter out, String string){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		Customer cust = Customers.cust0;
		cust.setAddress((Address)context.getBean("addressFixture"));
		boolean v = cust.verify();
		out.println("Customer Salomon was verified with result: " + v);
		CustomerHibernateDAO custDAO = new CustomerHibernateDAO();
		custDAO.addCustomer(cust);
		Customer retrieved = custDAO.retrieveCustomer(1);
		custDAO.deleteCustomer(retrieved);
		out.println(cust.synopsis());
		out.println("looks good jim!");
	}
	
	protected void demoBeans(PrintWriter out, String string, ApplicationContext context){
		
	}
	
	protected void demoDB(PrintWriter out, String string, ApplicationContext context){
		
	}
	
	protected String objectResult(){
		return "";
	}
}
