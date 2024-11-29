import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
 
public class Login extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean loggedin=false;
		String uname=req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		HttpSession session = req.getSession();
		PrintWriter out= resp.getWriter();
		try
		{
			Connection con = DB_Connector.getDbConnection();
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select * from login_user");
			while (rs.next())
			{
				if(uname.equals(rs.getString("username"))&& pwd.equals(rs.getString("passwd")))
						{
					      
							session.setAttribute("uname", uname);
							JSONObject jo = new JSONObject();
							jo.put("status", "success");
							loggedin=true;
							out.println(jo.toString());
					
						}
			}
			if(loggedin==false)
		      {
				JSONObject jo = new JSONObject();
				jo.put("status", "failed");
				out.println(jo.toString());
		      }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
		
		
		//super.doGet(req, resp);
	}
	

}
