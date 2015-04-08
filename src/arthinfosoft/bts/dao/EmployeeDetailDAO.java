package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.util.DBConnection1;
import arthinfosoft.bts.util.DBconnection;

public class EmployeeDetailDAO {
	
	public boolean insertData(EmployeeDetailBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String insertSQL = "insert into bts.employee_detail(email,password,security_question,answer,employee_firstname,employee_lastname,permanent_address,temporary_address,mobile,landline,dateofbirth,designation,joining_date,is_active,role_id,Department_id,Manager_id,salary) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, bean.getEmail());
				pstmt.setString(2, bean.getPassword());
				pstmt.setString(3, bean.getSecurity_question());
				pstmt.setString(4, bean.getAnswer());
				pstmt.setString(5, bean.getEmployee_firstname());
				pstmt.setString(6, bean.getEmployee_lastname());
				pstmt.setString(7, bean.getPermanent_address());
				pstmt.setString(8, bean.getTemporary_address());
				pstmt.setString(9, bean.getMobile());
				pstmt.setString(10, bean.getLandline());
				pstmt.setString(11, bean.getDateofbirth());
				pstmt.setInt(12, bean.getDesignation());
				pstmt.setString(13, bean.getJoining_date());
				pstmt.setString(14, bean.getIs_active());
				pstmt.setInt(15, bean.getRole_id());
				pstmt.setInt(16, bean.getdepartment_id());
				pstmt.setInt(17, bean.getManager_id());
				pstmt.setInt(18, bean.getSalary());
				
				int result = pstmt.executeUpdate();
				if (result > 0) {
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	public List<EmployeeDetailBean> listData() {

		List<EmployeeDetailBean> list = new ArrayList<EmployeeDetailBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		EmployeeDetailBean bean = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			String listSQL = "select * from bts.employee_detail a,bts.role_employee b,bts.department c,bts.manager_employee d,bts.employee_detail e where a.role_id=b.role_id and a.department_id=c.department_id and a.manager_id=d.manager_id and d.employee_id=e.employee_id";
			try {
				pstmt = conn.prepareStatement(listSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new EmployeeDetailBean();
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
					bean.setRole_name(rs.getString("role_description"));
					bean.setdepartment_id(rs.getInt("a.department_id"));
					bean.setDepartment_name(rs.getString("department_description"));
					bean.setManager_id(rs.getInt("a.manager_id"));
					bean.setManager_name(rs.getString("e.employee_firstname")+" "+rs.getString("e.employee_lastname"));
					bean.setSalary(rs.getInt("a.salary"));
				
			/*		
					//role_employee details
					Role_EmployeeBean rebean = new Role_EmployeeBean();
					rebean.setRole_id(rs.getInt("role_id"));
					
					bean.setRebean(rebean);
					//department details
					
					DepartmentBean dbean=new DepartmentBean();
					dbean.setDepartment_id(rs.getInt("department_id"));
					dbean.setDepartment_description(rs.getString("department_description"));
					dbean.setManager_id(rs.getInt("manager_id"));
					dbean.setMax_limit(rs.getInt("max_limit"));
					bean.setDbean(dbean);
					
					//manager_employee details
					
					ManagerEmployeeBean mbean=new  ManagerEmployeeBean();
					mbean.setEmployee_id(rs.getInt("employee_id"));
					mbean.setManager_id(rs.getInt("manager_id"));
					bean.setMbean(mbean);
					//manager as employee details
					
					EmployeeDetailBean ebean = new EmployeeDetailBean();
					ebean.setEmployee_id(rs.getInt("e.employee_id"));
					ebean.setEmail(rs.getString("e.email"));
					ebean.setPassword(rs.getString("e.password"));
					ebean.setSecurity_question(rs.getString("e.security_question"));
					ebean.setAnswer(rs.getString("e.answer"));
					ebean.setEmployee_firstname(rs.getString("e.employee_firstname"));
					ebean.setEmployee_lastname(rs.getString("e.employee_lastname"));
					ebean.setPermanent_address(rs.getString("e.permanent_address"));
					ebean.setTemporary_address(rs.getString("e.temporary_address"));
					ebean.setMobile(rs.getString("e.mobile"));
					ebean.setLandline(rs.getString("e.landline"));
					ebean.setDateofbirth(rs.getString("e.dateofbirth"));
					ebean.setDesignation(rs.getInt("e.designation"));
					ebean.setJoining_date(rs.getString("e.joining_date"));
					ebean.setIs_active(rs.getString("e.is_active"));
					ebean.setRole_id(rs.getInt("e.role_id"));
					ebean.setdepartment_id(rs.getInt("e.department_id"));
					ebean.setmanager_id(rs.getInt("e.manager_id"));
					ebean.setSalary(rs.getInt("e.salary"));
				bean.setEbean(ebean);
				*/	
					list.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public EmployeeDetailBean editData(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeDetailBean bean=new EmployeeDetailBean();
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String selectSQL = "Select * from bts.employee_detail where employee_id=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean.setEmployee_id(rs.getInt("employee_id"));
					bean.setEmail(rs.getString("email"));
					bean.setPassword(rs.getString("password"));
					bean.setSecurity_question(rs.getString("security_question"));
					bean.setAnswer(rs.getString("answer"));
					bean.setEmployee_firstname(rs.getString("employee_firstname"));
					bean.setEmployee_lastname(rs.getString("employee_lastname"));
					bean.setPermanent_address(rs.getString("permanent_address"));
					bean.setTemporary_address(rs.getString("temporary_address"));
					bean.setMobile(rs.getString("mobile"));
					bean.setLandline(rs.getString("landline"));
					bean.setDateofbirth(rs.getString("dateofbirth"));
					bean.setDesignation(rs.getInt("designation"));
					bean.setJoining_date(rs.getString("joining_date"));
					bean.setIs_active(rs.getString("is_active"));
					bean.setRole_id(rs.getInt("role_id"));
					bean.setdepartment_id(rs.getInt("department_id"));
					bean.setManager_id(rs.getInt("manager_id"));
					bean.setSalary(rs.getInt("salary"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		return bean;
	}

	public boolean updateData(EmployeeDetailBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			try {
				String updateSQL = "update bts.employee_detail set password=?,security_question=?,answer=?,employee_firstname=?,employee_lastname=?,permanent_address=?,temporary_address=?,mobile=?,landline=?,dateofbirth=?,designation=?,joining_date=?,is_active=?,role_id=?,department_id=?,manager_id=?,salary=?,email=?  where employee_id=?";
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(18,bean.getEmail());
				pstmt.setString(1, bean.getPassword());
				pstmt.setString(2, bean.getSecurity_question());
				pstmt.setString(3, bean.getAnswer());
				pstmt.setString(4, bean.getEmployee_firstname());
				pstmt.setString(5, bean.getEmployee_lastname());
				pstmt.setString(6, bean.getPermanent_address());
				pstmt.setString(7, bean.getTemporary_address());
				pstmt.setString(8, bean.getMobile());
				pstmt.setString(9, bean.getLandline());
				pstmt.setString(10, bean.getDateofbirth());
				pstmt.setInt(11, bean.getDesignation());
				pstmt.setString(12, bean.getJoining_date());
				pstmt.setString(13, bean.getIs_active());
				pstmt.setInt(14, bean.getRole_id());
				pstmt.setInt(15, bean.getdepartment_id());
				pstmt.setInt(16, bean.getManager_id());
				pstmt.setInt(17, bean.getSalary());
				pstmt.setInt(19, bean.getEmployee_id());
				int result = pstmt.executeUpdate();
				if (result > 0) {
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return flag;
	}

	public boolean deleteData(int id) {
		boolean flag = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String deleteSQL = "delete from bts.employee_detail where employee_id=?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, id);
				int result = pstmt.executeUpdate();
				if (result > 0) {
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return flag;
	}

}
