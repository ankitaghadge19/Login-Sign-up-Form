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
import java.sql.SQLException;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		
		PreparedStatement ps;
		ResultSet rs;
		Connection con;
		RequestDispatcher rd;
		int count = 0;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ankita","root","1234");
			
			String Query = "select * from LoginRegister";
			
			ps = con.prepareStatement(Query);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				if(email.equals(rs.getString("username")) && pass.equals(rs.getString("password")))
				{
					count = 1;
				}
			}
			
			if(count == 1)
			{
				request.setAttribute("status", "Login succecssful! "+email);
				rd= request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("status", "Login failed! Try again!");
				rd= request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
