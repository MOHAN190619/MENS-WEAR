import java.sql.Connection;
	import java.sql.DriverManager;

public class connection {



	
		public static Connection getConnection() {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/ wearmens","root","99449626");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return con;
			
		}

	}
 