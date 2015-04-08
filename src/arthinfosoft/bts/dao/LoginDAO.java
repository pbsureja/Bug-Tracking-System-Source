package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import arthinfosoft.bts.bean.Client_DetailsBean;
import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.util.DBconnection;

public class LoginDAO {

	public EmployeeDetailBean AutheticateAdmin(String username,String password,String type){
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	conn = DBconnection.getConnection();
if(conn!=null){
	
	String queryadmin="select * from bts.employee_detail a,bts.manager_employee b where a.email=? and a.password=? and a.employee_id=b.employee_id";
		try{
		pstmt=conn.prepareStatement(queryadmin);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		rs=pstmt.executeQuery();
		rs.next();
		
		EmployeeDetailBean bean = new EmployeeDetailBean();
		bean.setEmployee_id(rs.getInt("a.employee_id"));
		bean.setEmail(rs.getString("a.email"));
		bean.setPassword(rs.getString("a.password"));
		bean.setSecurity_question(rs.getString("a.security_question"));
		bean.setAnswer(rs.getString("a.answer"));
		bean.setEmployee_firstname(rs.getString("a.employee_firstname"));
		bean.setEmployee_lastname(rs.getString("a.employee_lastname"));
		bean.setPermanent_address(rs.getString("a.permanent_address"));
		bean.setTemporary_address(rs.getString("a.temporary_address"));
		bean.setMobile(rs.getString("a.mobile"));
		bean.setLandline(rs.getString("a.landline"));
		bean.setDateofbirth(rs.getString("a.dateofbirth"));
		bean.setDesignation(rs.getInt("a.designation"));
		bean.setJoining_date(rs.getString("a.joining_date"));
		bean.setIs_active(rs.getString("a.is_active"));
		bean.setRole_id(rs.getInt("a.role_id"));
		bean.setdepartment_id(rs.getInt("a.department_id"));
		bean.setManager_id(rs.getInt("a.manager_id"));
		bean.setSalary(rs.getInt("a.salary"));
	return bean;
		}catch(Exception e){
e.printStackTrace();			
		}
}
	return null;
}

public Client_DetailsBean AutheticateClient(String username,String password,String type){
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
ResultSet rs=null;
	conn = DBconnection.getConnection();
	
	if(conn!=null){	
	String queryclient="select * from bts.client_details a where a.client_details_email=? and a.client_details_password=?";
	
		try{
			pstmt=conn.prepareStatement(queryclient);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			rs.next();	
			Client_DetailsBean cbean = new Client_DetailsBean();
			cbean.setClient_id(rs.getInt("a.client_details_id"));
			cbean.setClient_name(rs.getString("a.client_details_name"));
			cbean.setPassword(rs.getString("a.client_details_password"));
			cbean.setSecurityquestion(rs.getString("a.client_details_securityquestion"));
			cbean.setAnswer(rs.getString("a.client_details_answer"));
			cbean.setPhone_no(rs.getString("a.client_details_phone_no"));
			cbean.setAddress(rs.getString("a.client_details_address"));
			cbean.setFax(rs.getString("a.client_details_fax"));
			cbean.setWebsite(rs.getString("a.client_details_website"));
			return cbean;
		
		
		}catch(Exception e){
e.printStackTrace();
}
		
		
	
	}
	return null;
	
}



public EmployeeDetailBean AutheticateEmployee(String username,String password,String type){
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	conn = DBconnection.getConnection();
	if(conn!=null){
	String queryemployee="select * from bts.employee_detail a where a.email=? and a.password=?";
		try{
			pstmt=conn.prepareStatement(queryemployee);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			System.out.println("username:"+username+"password:"+password);
			rs=pstmt.executeQuery();
			
			rs.next();
			EmployeeDetailBean bean = new EmployeeDetailBean();
			bean.setEmployee_id(rs.getInt("a.employee_id"));
			bean.setEmail(rs.getString("a.email"));
			bean.setPassword(rs.getString("a.password"));
			bean.setSecurity_question(rs.getString("a.security_question"));
			bean.setAnswer(rs.getString("a.answer"));
			bean.setEmployee_firstname(rs.getString("a.employee_firstname"));
			bean.setEmployee_lastname(rs.getString("a.employee_lastname"));
			bean.setPermanent_address(rs.getString("a.permanent_address"));
			bean.setTemporary_address(rs.getString("a.temporary_address"));
			bean.setMobile(rs.getString("a.mobile"));
			bean.setLandline(rs.getString("a.landline"));
			bean.setDateofbirth(rs.getString("a.dateofbirth"));
			bean.setDesignation(rs.getInt("a.designation"));
			bean.setJoining_date(rs.getString("a.joining_date"));
			bean.setIs_active(rs.getString("a.is_active"));
			bean.setRole_id(rs.getInt("a.role_id"));
			bean.setdepartment_id(rs.getInt("a.department_id"));
			bean.setManager_id(rs.getInt("a.manager_id"));
			bean.setSalary(rs.getInt("a.salary"));
		return bean;
		}catch(Exception e){
				e.printStackTrace();
			}
	
}
	return null;
}
}
