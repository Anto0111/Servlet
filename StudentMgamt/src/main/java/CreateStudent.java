import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateStudent extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		
		PrintWriter out= resp.getWriter();
		String Insert_Sql= "INSERT INTO student (name,email)values"+"(?,?);";
		String name ="";
		String email ="";
		name=req.getParameter("name");
		email=req.getParameter("email");
		Statement stmt = null;
		resp.addHeader("Access-Control-Allow-Origin", "*");
		Connection connection = DB_Connector.getDbConnection();
		stmt=connection.createStatement();
		PreparedStatement preparedStatement =connection.prepareStatement(Insert_Sql);
		preparedStatement.setString(1,name);
		preparedStatement.setString(2,email);
		preparedStatement.executeUpdate();
		out.println("Data ins success");
		
		}
		catch(Exception e)
		{
			
		}
		
		
		//super.doGet(req, resp);
	}

}
