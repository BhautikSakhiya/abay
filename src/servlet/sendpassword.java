package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.sql.*;

import dao.db;
import servlet.sendpassword.SMTPAuthenticator;


@WebServlet("/sendpassword")
public class sendpassword extends HttpServlet {
	
	String senderEmailID = "bhautiksakhiya005@gmail.com";
	String senderPassword = "gj3fs5590";
	String emailSMTPserver = "smtp.gmail.com";
	String emailServerPort = "465";
	String senderName = "Bhautik Sakhiya";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiverEmailID = request.getParameter("email");
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = db.getCon();
			st = con.createStatement();
			rs = st.executeQuery( "SELECT password FROM user where email='"+receiverEmailID+"'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String emailSubject = "ABay";
		
		Properties props = new Properties();
			props.put("mail.smtp.port", emailServerPort);
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.socketFactory.port", emailServerPort);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			props.put("mail.smtp.user",senderEmailID);
			props.put("mail.smtp.host", emailSMTPserver);
		
		SecurityManager security = System.getSecurityManager();
		
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props, auth);
			session.setDebug(false);
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setSubject(emailSubject);
		} catch (MessagingException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		try {rs.next();
			msg.setText("Mail from ABay " + "Your password is " + rs.getString("password"));
		} catch (MessagingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			msg.setFrom(new InternetAddress(senderEmailID));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			msg.addRecipient(Message.RecipientType.TO,
					   new InternetAddress(receiverEmailID));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Transport.send(msg);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.print("Message send Successfully..");
	}
		public class SMTPAuthenticator extends javax.mail.Authenticator{
			public PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(senderEmailID, senderPassword);
			}
		} 
	}


