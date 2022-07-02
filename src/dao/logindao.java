package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class logindao {
	public static long id;

	public boolean validate(String email, String password) {
//		return false;
		try {
			Connection con = db.getCon();
			PreparedStatement ps = con.prepareStatement("select * from user where email = ? and password =?",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
				return true;
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
		
	}
}
