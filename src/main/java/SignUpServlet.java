//Babita Gurung
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signupservlet")
public class SignUpServlet extends HttpServlet {
	Connection conn = null;// initially connection is null
	List<UserDTO> list = new ArrayList<UserDTO>();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		UserDTO userDTO = new UserDTO(username, password, email, gender);
		try {
			// Step 1: Loading the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Creating connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "Manandhar@12345");
			if (conn != null) {
				System.out.println("Connection establised successfully with database.");
			}

			// Step 3: Creating statement where we pass our queries
			PreparedStatement ps = conn.prepareStatement("insert into user_table values (?,?,?,?)");
			ps.setString(1, username); // (pointing 1st ? , value)
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, gender);

			// Step 4: Executing queries
			int modifiedRows = ps.executeUpdate();
			// System.out.println(modifiedRows);

			if (modifiedRows == 1) {
				System.out.println("Inserted successful.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Step 5: Closing connection
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list.add(userDTO);
		System.out.println(list);

		req.setAttribute("regsuccess", "Successfully registered. Now you can login.");
		// req.setAttribute("signuplist", list);
		req.getRequestDispatcher("Success.jsp").forward(req, resp);
	}
}
