package ashok.it;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = DBUtil.getConnection();
	public LoginServlet() {
		System.out.println("inside login servlet");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		User user = new User();
		System.out.println("inside doGet");
		String pass2=null;
		HttpSession session = null;
		Long mobilenumber= Long.parseLong(req.getParameter("mobilenumber"));
		String password = req.getParameter("password");
		String query2 = "select password from register where mobilenumber='"+mobilenumber+"' and password='"+password+"'";
		try {
		Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query2);
			while(rs.next()) {
				pass2=rs.getString("password");
			}
			
			if(mobilenumber==1234567890 && password.equals("admin12")) {
				  req.getRequestDispatcher("menu.html").forward(req, resp);
			}
			else if(pass2!=null) {
				session = req.getSession(true);
				session.setAttribute("mobilenumber", mobilenumber);
		    req.getRequestDispatcher("menu.html").forward(req, resp);
			}
			else {
				 out.println("<h1>invalid mobile number or password</h1>");
			        req.getRequestDispatcher("login.html").include(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
