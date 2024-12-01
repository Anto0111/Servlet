import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connector {
	
	public static Connection getDbConnection()
	{
		Connection con= null;
		String db_url="jdbc:postgresql://localhost:5432/student";
		String name="postgres";
		String email="postgres";
		
		try
		{
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(db_url,name,email);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}

}
