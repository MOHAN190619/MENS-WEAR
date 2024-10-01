

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class calculate
 */
public class calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public calculate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		

		        String productName = request.getParameter("productName");
		        String description = request.getParameter("description");
		        int quantity = Integer.parseInt(request.getParameter("quantity"));
		        double price = Double.parseDouble(request.getParameter("price"));
		        String username = request.getParameter("username");
		        String address = request.getParameter("address");
		        String phone = request.getParameter("phone");
		        
		        double totalPrice = quantity * price;
		        
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        out.println("<html><body>");
		        out.println("<h2>Calculation Result</h2>");
		        out.println("Username: " + username + "<br>");
		        out.println("Address: " + address + "<br>");
		        out.println("Phone No: " + phone + "<br>");
		        out.println("Product Name: " + productName + "<br>");
		        out.println("Description: " + description + "<br>");
		        out.println("Quantity: " + quantity + "<br>");
		        out.println("Price per item: $" + price + "<br>");
		        out.println("<strong>Total Price: $" + totalPrice + "</strong><br>");
		        out.println("</body></html>");
		        out.close();
		    }
		

		
		
		
		
	}


