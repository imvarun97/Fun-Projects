package com.caps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/text")
public class FunProject extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String text=req.getParameter("text");
		System.out.println(text);
		System.out.println("**********************************");
		String b= req.getRequestURL().toString();
		//String c=req.get
		System.out.println("Requested Url:"+b);
		//string c=req.
		PrintWriter out = resp.getWriter();
		out.println("<h1>Successfully Submitted!!! Thank You for telling about me!!!!</h1>");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/*
			 * 1. Load the Driver
			 */
			Class.forName("com.mysql.jdbc.Driver");
			
			/*
			 * 2. Get the DB Connection via Driver
			 */
						String dbUrl="jdbc:mysql://localhost:3306/capsv4_db?user=root&password=1387";
						
			//2nd Version of getConnection
				//FileReader in = new FileReader("E:/Files/db.properties");
				//Properties prop = new Properties();
				//prop.load(in);
				con = DriverManager.getConnection(dbUrl);
						
 			//System.out.println("Connected...");
			
			/*
			 * 3. Issue the SQL query via connection
			 */
			String sql = "insert into fun values(?)";
 			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,text);
		int count = pstmt.executeUpdate();
			
		
			
 			/*
			 * 4. Process the results
			 */
			
			/*if(rs.next()){
				int regno = rs.getInt("sid");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				passwd = rs.getString("password");
				String type = rs.getString("type");
 				out.println(regno);
				out.println(firstname);
				out.println(lastname);
				out.println(gender);
				out.println(passwd);
				out.println(type);
				out.println("*********************");
			}else {
				out.println("Login Failed");
			}*/
		
		} catch (Exception e) {
			e.printStackTrace();
		} 
			finally {
			// 5. close all the JDBC Objects
					/*try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
		}
	}

	private void Buffer() {
		// TODO Auto-generated method stub
		
	}
		//String lastname=req.getParameter("lname");
		/*System.out.println(text);
		System.out.println(lastname);
		System.out.println("requested method"+req.getMethod());
		System.out.println("values sent"+req.getParameter("fname"));
		String name[]=req.getParameterValues("fname");
		System.out.println(Arrays.toString(name));
		System.out.println("protocol"+req.getProtocol());
		
		
		
		
		
		
		PrintWriter out=resp.getWriter();
		//out.println("<h1>The Date is: "+ new Date() +" </h1>");
		out.println("firstName:"+firstname+"\n"+"Lastname:"+lastname);
		out.println("<h1>The Date is: "+ new Date() +" </h1>");*/
}


