package dao;
import java.sql.*;

import bean.productbean;
import dao.db;

public class productdao {
	public static int add(productbean bean) {
		int status =0;
		try {
			Connection con = db.getCon();
			PreparedStatement ps = con.prepareStatement("insert into products(category,image,productname,productdetail,price,mobileno,address)values(?,?,?,?,?,?,?)");
			ps.setString(1, bean.getCategory());
			ps.setString(2, bean.getImage());
			ps.setString(3, bean.getProductname());
			ps.setString(4, bean.getProductdetail());
			ps.setString(5, bean.getPrice());
			ps.setString(6, bean.getMobileno());
			ps.setString(7, bean.getAddress());
			
			status =  ps.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
}
