package dao;
import java.sql.*;
import java.util.*;
import bean.userbean;
import dao.db;
public class userdao {
	public static long id;
	
	public static int save(userbean bean){
		int status=0;
		ResultSet rs = null;
		try{
			Connection con=db.getCon();
			PreparedStatement ps=con.prepareStatement("insert into user(name,mobile,email,address,password) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getMobile());
			ps.setString(3,bean.getEmail());
			ps.setString(4,bean.getAddress());
			ps.setString(5,bean.getPassword());
			rs = ps.getGeneratedKeys();
			status=ps.executeUpdate();
			
    		while(rs.next()) {
    			id = rs.getInt(1);
    		}
    		System.out.println(id +"==========");
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int update(userbean bean){
		int status=0;
		try{
			Connection con=db.getCon();
			PreparedStatement ps=con.prepareStatement("update user set name=?,mobile=?,email=?,address=?,password=? where id=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getMobile());
			ps.setString(3,bean.getEmail());
			ps.setString(4,bean.getAddress());
			ps.setString(5,bean.getPassword());
			ps.setInt(6,bean.getId());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<userbean> view(){
		List<userbean> list=new ArrayList<userbean>();
		try{
			Connection con=db.getCon();
			PreparedStatement ps=con.prepareStatement("select * from user");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				userbean bean=new userbean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setMobile(rs.getString("mobile"));
				bean.setEmail(rs.getString("email"));
				bean.setAddress(rs.getString("address"));
				bean.setPassword(rs.getString("password"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	
	public static userbean viewById(int id){
		userbean bean=new userbean();
		try{
			Connection con=db.getCon();
			PreparedStatement ps=con.prepareStatement("select * from user where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setMobile(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setAddress(rs.getString(5));
				bean.setPassword(rs.getString(6));
				
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=db.getCon();
			PreparedStatement ps=con.prepareStatement("delete from user where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			Connection con = db.getCon();
			PreparedStatement ps=con.prepareStatement("select * from user where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			rs.next();
			if(rs.getString("email").equals(email) && rs.getString("password").equals(password)){
				status=true;
		}
		con.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return status;
	}
}
