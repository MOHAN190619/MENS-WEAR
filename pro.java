import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
@WebServlet("/pro")
public class pro extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public pro() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String name=request.getParameter("user");
		String phonenumber=request.getParameter("ph");
		String address=request.getParameter("add");
		
		PreparedStatement ps;
		String q="INSERT INTO products(`NAME`,`PHONE NUMBER`,`ADDRESS`)values(?,?,?)";
		try {
				ps=connection.getConnection().prepareStatement(q);
				ps.setString(1, name);
				ps.setString(2,phonenumber);
				ps.setString(3,address);
		
				if(ps.executeUpdate()>0) {
					 response.sendRedirect("search.html");
				}
				else {
					pw.println("invalid");
				}
	}catch(Exception ex) {
		System.out.println("ex");
	}

	}
}
