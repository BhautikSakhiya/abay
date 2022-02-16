package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.userbean;
import dao.userdao;
@WebServlet("/edituser")
public class edituser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public edituser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		userbean bean=userdao.viewById(id);
		out.print("<form action='edituser2' method='post' style='width:300px'>");
		out.print("<div class='form-group'>");
		out.print("<input type='hidden' name='id' value='"+bean.getId()+"'/>");
		out.print("<label for='name1'>Name</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getName()+"' name='name' id='name1' placeholder='Name'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='mobile1'>Mobile Number</label>");
		out.print("<input type='number' class='form-control' value='"+bean.getMobile()+"'  name='mobile' id='mobile1' placeholder='Mobile'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='email1'>Email</label>");
		out.print("<input type='email' class='form-control' value='"+bean.getEmail()+"'  name='email' id='email1' placeholder='Email'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='address1'>Address</label>");
		out.print("<input type='text' class='form-control' value='"+bean.getAddress()+"'  name='address' id='address1' placeholder='Address'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='password1'>Password</label>");
		out.print("<input type='password' class='form-control' value='"+bean.getPassword()+"'  name='password' id='password1' placeholder='Password'/>");
		out.print("</div>");
				 	
		out.print("<button type='submit' class='btn btn-primary'>Update</button>");
		out.print("</form>");
		
	
	}

}
