package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.userbean;
import dao.userdao;
@WebServlet("/adduser")
public class adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public adduser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();

		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String password=request.getParameter("password");
		
		userbean bean=new userbean(name, mobile, email, address ,password );
		userdao.save(bean);
		
		HttpSession session = request.getSession();
		request.getRequestDispatcher("user.jsp").include(request, response);
		out.print("<h4> added successfully</h4>");
	
	}

}
