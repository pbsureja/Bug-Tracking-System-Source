package arthinfosoft.bts.util;

import java.sql.DriverManager;
import java.sql.Connection;


public class DBconnection {
public static String url="jdbc:mysql://localhost:3306/";
public static  String driverName="com.mysql.jdbc.Driver";
public static  String userName="root";
public static  String password="";

public static Connection getConnection(){
	Connection conn=null;
	try {
		Class.forName(driverName);
		
		conn=DriverManager.getConnection(url,userName,password);
		if(conn!=null){
			System.out.println("Connected to DB...");
		}else{
			System.out.println("Not Connected to DB...");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return conn;
}
public static void main(String[] args) {
	DBconnection.getConnection();
}
}