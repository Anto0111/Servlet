import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		PrintWriter out= arg1.getWriter();
		HttpServletRequest req=(HttpServletRequest)arg0;
		HttpSession session = req.getSession(false);
		String url=req.getContextPath()+"/login";
		boolean loggedin = session!=null && session.getAttribute("uname")!=null;
		boolean loginRequest=req.getRequestURI().equals(url);
		
		if(loggedin || loginRequest)
		{
			arg2.doFilter(arg0, arg1);
		}
		else
		{
			JSONObject jo = new JSONObject();
			jo.put("status", "failed");
			out.println(jo.toString());
		}
		
	}

}
