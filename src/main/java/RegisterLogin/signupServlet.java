package RegisterLogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class signupServlet
 */

public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupServlet() {
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
		//doGet(request, response);
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String cpass = request.getParameter("cpass");
		
		PreparedStatement ps;
		ResultSet rs;
		Connection con;
		RequestDispatcher rd;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ankita","root","1234");
			String Query = "insert into LoginRegister values(?, ?)";
			
			ps = con.prepareStatement(Query);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				request.setAttribute("status", "Successfully Signed up! Now you can Login here!");
				rd= request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("status", "Failed to Sign up! Please try again.");
				rd= request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
