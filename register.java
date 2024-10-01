

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
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
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String name=request.getParameter("user");
		
		String password=request.getParameter("pass");
		
		String phonenumber=request.getParameter("Ph");
		
		String address=request.getParameter("adds");
		
		
		PreparedStatement ps;
		String query="INSERT INTO register (`NAME`,`PASSWORD`,`PHONE NUMBER`,`ADDRESS`)values(?,?,?,?)";
		try {
			ps=connection.getConnection().prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, phonenumber);
			ps.setString(4, address);
		
	
			
			if(ps.executeUpdate()>0) 
			{
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.include(request, response);
				pw.print("<p style=text-align:center;color:blue;>NEW USER REGISTERED</p>");
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.include(request, response);
				pw.print("<p style=text-align:center;color:blue;>NEW USER NOT REGISTERED</p>");
			}
		}
		 catch(Exception ex){
	            System.out.println(ex);
	        
	        }


	}

}
