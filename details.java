

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 * Servlet implementation class details
 */
public class details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public details() {
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
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("user");
		try {
			String query="select * from products where NAME=?";
			PreparedStatement ps;
			ps=connection.getConnection().prepareStatement(query);
			
		ps.setString(1, name);
			 ResultSet rs=ps.executeQuery();
			 pw.println("<table border='1'><tr><th>name</th><th>phonenumber</th><th>address</th><th>product</th><th>quntity</th><th>price</th><th>total</th></tr>");
	            
			 if(rs.next())
	            {	 
				
				 
		          String phonenumber=rs.getString(2);
		          String address=rs.getString(3);
		          String product=rs.getString(4);
		          String quntity=rs.getString(5);
		          String price=rs.getString(6);
		          String total=rs.getString(7);
			         

		          pw.println("<tr><td>" +name+ "</td><td>" +phonenumber + "</td><td>" +address+ "</td><td>" +product+"</td><td>"+quntity+"</td><td>"+price+"</td><td>"+total+ "</td></tr>");
		          
		          RequestDispatcher rd=request.getRequestDispatcher("orderdetails.html");
		          rd.include(request,response);
		            	
			 
	            }
	 		 else
	         {
	        RequestDispatcher rd=request.getRequestDispatcher("update.html");
		          rd.include(request,response);
		         pw.print("<p style=text-align:center;color:red;>name doesnot exist</p>");
	         }
			}
		
			
			catch(Exception ex)
			{
		      System.out.println(ex);
			}
	}



}