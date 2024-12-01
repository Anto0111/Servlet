import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpadateStudent extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		PrintWriter out=resp.getWriter();
		Statement stmt = null;
		String name="";
		String email="";
		name= req.getParameter("name");
		email= req.getParameter("email");
		resp.addHeader("Access-Control-Allow-Origin", "*");
		Connection connection=DB_Connector.getDbConnection();
		stmt=connection.createStatement();
		stmt.executeUpdate("Update student set name="+name+"where email="+email+";");
		JSONObject jo=new JSONObject();
		jo.put("status", "success");
		out.println(jo);
		
		}
		catch(Exception e)
		{
			
		}
		
		//super.doGet(req, resp);
	}

}
