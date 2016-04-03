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
import com.FManSSC.model.backbones.Phone;
import com.FManSSC.model.backbones.Time;
import com.FManSSC.model.backbones._Synopsis;
import com.FManSSC.model.backbones._Verifiable;
import com.FManSSC.model.customer.Customer;
import com.FManSSC.model.facility.Facility;
import com.FManSSC.model.owner.Owner;
import com.FManSSC.model.reservation.Reservation;
import com.FManSSC.model.room.Room;
import com.FManSSC.model.ticket.Ticket;

import Fixtures.Addresses;
import Fixtures.Customers;
import Fixtures.Facilities;
import Fixtures.Owners;
import Fixtures.Phones;
import Fixtures.Reservations;
import Fixtures.Rooms;
import Fixtures.Tickets;
import Fixtures.Times;

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
	
	protected void demoPOJO(PrintWriter out, String PREFIX){
		out.println(PREFIX + "POJO Address");
		out.println(objectSynopsis(PREFIX,Addresses.add0));
		out.println(objectVerification(PREFIX,Addresses.add0));
		out.println();
		out.println(PREFIX + "POJO Customer");
		out.println(objectSynopsis(PREFIX,Customers.cust0));
		out.println(objectVerification(PREFIX,Customers.cust0));
		out.println();
		out.println(PREFIX + "POJO Facility");
		out.println(objectSynopsis(PREFIX,Facilities.fa0));
		out.println(objectVerification(PREFIX,Facilities.fa0));
		out.println();
		out.println(PREFIX + "POJO Owner");
		out.println(objectSynopsis(PREFIX,Owners.own0));
		out.println(objectVerification(PREFIX,Owners.own0));
		out.println();
		out.println(PREFIX + "POJO Phone");
		out.println(objectVerification(PREFIX,Phones.ph0));
		out.println();
		out.println(PREFIX + "POJO Reservation");
		out.println(objectSynopsis(PREFIX,Reservations.re0));
		out.println(objectVerification(PREFIX,Reservations.re0));
		out.println();
		out.println(PREFIX + "POJO Room");
		out.println(objectSynopsis(PREFIX,Rooms.ro0));
		out.println(objectVerification(PREFIX,Rooms.ro0));
		out.println();
		out.println(PREFIX + "POJO Ticket");
		out.println(objectSynopsis(PREFIX,Tickets.ti0));
		out.println(objectVerification(PREFIX,Tickets.ti0));
		out.println();
		out.println(PREFIX + "POJO Time");
		out.println(objectVerification(PREFIX,Times.ti0));
		out.println();
	}
	
	protected void demoBeans(PrintWriter out, String PREFIX, ApplicationContext context){
		
		out.println(PREFIX + "Bean Address Verification");
		out.println(objectVerification(PREFIX,(Address)context.getBean("addressFixture")));
		out.println();
		out.println(PREFIX + "Bean Customer Verification");
		out.println(objectVerification(PREFIX,(Customer)context.getBean("customerFixture")));
		out.println();
		out.println(PREFIX + "Bean Facility Verification");
		out.println(objectVerification(PREFIX,(Facility)context.getBean("facilityFixture")));
		out.println();
		out.println(PREFIX + "Bean Owner Verification");
		out.println(objectVerification(PREFIX,(Owner)context.getBean("ownerFixture")));
		out.println();
		out.println(PREFIX + "Bean Phone Verification");
		out.println(objectVerification(PREFIX,(Phone)context.getBean("phoneFixture")));
		out.println();
		out.println(PREFIX + "Bean Reservation Verification");
		out.println(objectVerification(PREFIX,(Reservation)context.getBean("reservationFixture")));
		out.println();
		out.println(PREFIX + "Bean Room Verification");
		out.println(objectVerification(PREFIX,(Room)context.getBean("roomFixture")));
		out.println();
		out.println(PREFIX + "Bean Ticket Verification");
		out.println(objectVerification(PREFIX,(Ticket)context.getBean("ticketFixture")));
		out.println();
		out.println(PREFIX + "Bean Time Verification");
		out.println(objectVerification(PREFIX,(Time)context.getBean("timeFixturePast")));
		out.println();
	}
	
	protected void demoDB(PrintWriter out, String string, ApplicationContext context){
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
	
	protected String objectSynopsis(String PREFIX, _Synopsis obj){
		return PREFIX + "Synopsis:"+ obj.synopsis();
	}
	
	protected String objectVerification(String PREFIX, _Verifiable obj){
		return PREFIX + "Verification Result:" + obj.verify();
	}
}
