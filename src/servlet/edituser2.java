package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.userbean;
import dao.userdao;

@WebServlet("/edituser2")
public class edituser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edituser2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String password=request.getParameter("password");
		
		
		userbean bean=new userbean(id,name, mobile, email, address, password);
		userdao.update(bean);
		response.sendRedirect("admin.jsp");
	}

}
