package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public adminlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		if(email.equals("bhautiksakhiya005@gmail.com")&&password.equals("qwertyuiop")){
			HttpSession session = request.getSession();
			session.setAttribute("admin","true");
			
			request.getRequestDispatcher("admin.jsp").include(request, response);
		}else {
			request.getRequestDispatcher("index.jsp").include(request, response);
			out.println("<h3>Username or password error</h3>");

		}

	}
}