package ashok.it;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/rs")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con =DBUtil.getConnection();
   
    public RegisterServlet() {
        super();
        
    }



	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		System.out.println("inside do post");
		
		String name=req.getParameter("name");
		long mobile =Long.parseLong(req.getParameter("mobilenumber")); 
		String city =req.getParameter("city");
		String password=req.getParameter("password");
		try {
		String query = "insert into register values(?,?,?,?)";
		
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setString(1, name);
		pstmt.setLong(2, mobile);
		pstmt.setString(3, city);
		pstmt.setString(4, password);
		
		int no=pstmt.executeUpdate();
		
		if(no>=1) {
			
			req.getRequestDispatcher("login.html").forward(req, resp);	
			
		}
		else {
			 out.println("<h1>invalid mobile number or password</h1>");
		        req.getRequestDispatcher("register.html").include(req, resp);
		}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
