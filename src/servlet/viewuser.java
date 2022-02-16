package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.userbean;
import dao.userdao;
@WebServlet("/viewuser")
public class viewuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public viewuser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		out.println("<div class='container'>");

		List<userbean> list=userdao.view();
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Mobile</th><th>Email</th><th>Address</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
		for(userbean bean:list){
			out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getMobile()+
					"</td><td>"+bean.getEmail()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getPassword()+
					"</td><td><a href='edituser?id="+bean.getId()+"'>Edit</a></td>"
							+ "<td><a href='deleteuser?id="+bean.getId()+"'>Delete</a></td></tr>");
		
		}
		out.println("</table>");
		
//		out.println("</div>");
	}
}
