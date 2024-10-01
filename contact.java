

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
 * Servlet implementation class contact
 */
public class contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contact() {
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
		String email=request.getParameter("mail");
		String message=request.getParameter("msg");
		PreparedStatement ps;
		String q="INSERT into contact(`name`,`email`,`message`)values(?,?,?)";
		try {
		ps=connection.getConnection().prepareStatement(q);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3,message);
		if(ps.executeUpdate()>0) {
			RequestDispatcher  rd=request.getRequestDispatcher("contact1.html");
			rd.include(request,response);
			 pw.println("<script type=\"text/javascript\">");
		        pw.println("window.alert('Thank you for your enquiry');");
		        pw.println("</script>");
		       
			
		}
		}
		 catch(Exception ex){
	            System.out.println(ex);
	        
	        }

	}

}
