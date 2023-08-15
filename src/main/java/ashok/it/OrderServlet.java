package ashok.it;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con= DBUtil.getConnection();
       User user = new User();
   
    public OrderServlet() {
        super();
   
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ArrayList<User> list= new ArrayList<User>();
		String item = req.getParameter("item");
		double price = Integer.parseInt(req.getParameter("price"));
		int qty = Integer.parseInt(req.getParameter("qty"));
		double tprice = (price*qty) + 40;
		user.setItem(item);
		user.setPrice(price);
		user.setQty(qty);
		user.setTotalPrice(tprice);
	
		HttpSession session=req.getSession(false);
		long mob=0;
		if(session !=null) {
		  mob=(Long) session.getAttribute("mobilenumber");
		 
		System.out.println("inside order servlet");
		}
		String query2 = "select * from register where mobilenumber='"+mob+"'";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query2);
			while(rs.next()) {
				user.setName(rs.getString("name"));
				user.setMobilenumber(rs.getLong("mobilenumber"));
				user.setCity(rs.getString("city"));
			
				list.add(user);
			}
			
			session.setAttribute("list", list);
			req.getRequestDispatcher("order.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
