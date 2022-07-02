package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userdao;

@WebServlet("/userlogin")
public class userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public userlogin() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		logindao dao = new logindao();
//			if(dao.validate(email, password)) {
//				System.out.println("in is statement");
////				HttpSession session = request.getSession();
////				session.setAttribute("email",email);
//				request.getRequestDispatcher("user.jsp").include(request, response);
//			}else {
//				request.getRequestDispatcher("userlogin.jsp").include(request, response);
//				PrintWriter out=response.getWriter();
//				out.println("<h3>Username or password error</h3>");
//			}
//		
		
		userdao userdao = new userdao();
		if(dao.userdao.authenticate(email, password)) {
//			System.out.println("in if statement");
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("user.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
//			rd.include(request, response);
		}else{
			request.getRequestDispatcher("userlogin.jsp").include(request, response);
			PrintWriter out=response.getWriter();
			out.println("<h3>Username or password error</h3>");
		}
	
	}
}

