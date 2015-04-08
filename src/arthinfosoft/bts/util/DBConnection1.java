	package arthinfosoft.bts.util;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;


public class DBConnection1 {

		public static  String url="jdbc:mysql://localhost:3306/"; //specifying connection url
	 	public static String driverName="com.mysql.jdbc.Driver";
		public static String userName="root";
		public static String password="";
		
		public static Connection getConnection(){
			Connection conn=null;
			
			try{
				Class.forName(driverName);  //loading driver
				conn=DriverManager.getConnection(url,userName,password);
				if(conn!=null){
					System.out.println("DATABASE Connected!! ");
				}
				else{
					System.out.println("not connected");
				}
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return conn;
		
		
	}
	

}
