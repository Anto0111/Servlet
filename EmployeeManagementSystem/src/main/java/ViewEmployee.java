import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewEmployee extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JSONArray data = new JSONArray();
		
		
		
		PrintWriter out=resp.getWriter();
		
		String dbName="jdbc:postgresql://localhost:5432/emp";
		String dbDriver="org.postgresql.Driver";
		String username="postgres";
		String password="postgres";
		try
		{
			Class.forName(dbDriver);
			Connection con= DriverManager.getConnection(dbName,username,password);
			Statement st = con.createStatement();
			String sql="select * from employee";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				JSONObject row = new JSONObject();
				row.put("empid",rs.getInt("empid"));
				row.put("empname", rs.getString("empname"));
				row.put("email", rs.getString("email"));
				data.put(row);
				
				//out.println(rs.getInt("empid"));
				//out.println(rs.getString("empname"));
				//out.println(rs.getString("email"));
				
				
			}
			out.println(data);
			
		}
		catch(Exception e)
		{
			
		}
		
		
		
		//super.doGet(req, resp);
	}
	
}
