package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.buf.StringUtils;

import dao.db;
import dao.userdao;
import dao.logindao;

@WebServlet("/item")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
				maxFileSize=1024*1024*10,      // 10MB
				maxRequestSize=1024*1024*50)

public class item extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR="image";
    
    public item() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String savePath = "C:/Users/bhaut/eclipse-workspace/ABay/WebContent" +  File.separator + SAVE_DIR;
		File fileSaveDir = new File(savePath);
//		if(!fileSaveDir.exists()){
//            fileSaveDir.mkdir();
//        }
		String category = request.getParameter("category");
		String productname = request.getParameter("name");
		String productdetail = request.getParameter("detail");
		String price = request.getParameter("price");
		String mobileno = request.getParameter("mobileno");
		String address = request.getParameter("address");
//		
//		Part part = request.getPart("image");
//		System.out.println("PART FILE ==========" + part.getSubmittedFileName());
//		String fileName = extractFileName(part);
//		System.out.println("===================" + fileName);
//		part.write(savePath + File.separator +fileName);
		
		
		Connection con = null;
		PreparedStatement ps = null;
		Statement s = null;
		ResultSet rs = null;
		String fileName = null;
		
		
		List<String> fileNames = new ArrayList<>();
		for (Part part : request.getParts()) {
	        fileName = part.getSubmittedFileName();
	        part.write(savePath + File.separator + fileName);
	        if(!Objects.isNull(fileName)) {
	        	fileNames.add(fileName);
	        }
	    }
	 
		try {
	    	con = db.getCon();
//	    	String sql= "select mobile from user";
	    	s = con.createStatement();
	    	rs = s.executeQuery("select mobile from user");
	    	 while(rs.next()) {
	    		 rs.getString("mobile");
	    		 System.out.println(rs + "========");
	    	
			}
	    	ps = con.prepareStatement("insert into product(category,productname,productdetail,price,mobileno,address,id) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
	   			ps.setString(1, category);
	    		ps.setString(2, productname);
	    		ps.setString(3, productdetail);
	    		ps.setString(4, price);
	    		ps.setString(5, mobileno);
	    		ps.setString(6, address);
	    		ps.setLong(7, logindao.id);
	    		
	    		rs = ps.getGeneratedKeys();
	    		int row = ps.executeUpdate();
	    		long auto_id;
	    		rs.next();
	    			auto_id = rs.getInt(1);
	    		 
	    		System.out.println(rs);
	    		System.out.println("========Hww" + auto_id);
	    		
	    		int p=0 ;
	    		for(String name : fileNames) {
	    			ps = con.prepareStatement("insert into image (image,productid) values (?,?)");
	    			String filePath = savePath +  File.separator + name;
	    			ps.setString(1, filePath);
	    			ps.setLong(2, auto_id);
	    			p = ps.executeUpdate();
	    		}
	    		ps.close();
    			con.close();	
	    			
	    		if(row >0 && p >0) {
	    			out.print("added successfully ");
	    		}else {
	    			out.print("not added successfully ");
	    		}
	    			
	    	} catch (SQLException | ClassNotFoundException e) {
	    			// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	} 
	        	
	}
}
