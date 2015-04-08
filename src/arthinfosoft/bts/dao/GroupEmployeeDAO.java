package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.bean.GroupBean;
import arthinfosoft.bts.bean.GroupEmployeeBean;
import arthinfosoft.bts.util.DBConnection1;

public class GroupEmployeeDAO {

	public boolean insertData(GroupEmployeeBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String insertSQL = "insert into bts.group_employee(group_id,employee_id) values(?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setInt(1, bean.getGroup_id());
				pstmt.setInt(2, bean.getEmployee_id());
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

	public List<GroupEmployeeBean> listData() {

		List<GroupEmployeeBean> list = new ArrayList<GroupEmployeeBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		GroupEmployeeBean bean = null;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String listSQL = "select * from bts.group_employee a,bts.employee_detail b,bts.group c where a.employee_id=b.employee_id and a.group_id=c.group_id";
			try {
				pstmt = conn.prepareStatement(listSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new GroupEmployeeBean();
					bean.setGroup_id(rs.getInt("group_id"));
					bean.setEmployee_id(rs.getInt("employee_id"));
					
					//Employee Details
					
					EmployeeDetailBean ebean = new EmployeeDetailBean();
					ebean.setEmployee_id(rs.getInt("employee_id"));
					ebean.setEmail(rs.getString("email"));
					ebean.setPassword(rs.getString("password"));
					ebean.setSecurity_question(rs.getString("security_question"));
					ebean.setAnswer(rs.getString("answer"));
					ebean.setEmployee_firstname(rs.getString("employee_firstname"));
					ebean.setEmployee_lastname(rs.getString("employee_lastname"));
					ebean.setPermanent_address(rs.getString("permanent_address"));
					ebean.setTemporary_address(rs.getString("temporary_address"));
					ebean.setMobile(rs.getString("mobile"));
					ebean.setLandline(rs.getString("landline"));
					ebean.setDateofbirth(rs.getString("dateofbirth"));
					ebean.setDesignation(rs.getInt("designation"));
					ebean.setJoining_date(rs.getString("joining_date"));
					ebean.setIs_active(rs.getString("is_active"));
					ebean.setRole_id(rs.getInt("role_id"));
					ebean.setdepartment_id(rs.getInt("department_id"));
					ebean.setManager_id(rs.getInt("manager_id"));
					ebean.setSalary(rs.getInt("salary"));
				bean.setEbean(ebean);
					//Group Details
				
				GroupBean gbean = new GroupBean();
				gbean.setGroup_id(rs.getInt("group_id"));
				gbean.setGroup_description(rs.getString("group_description"));
				gbean.setMax_limit(rs.getInt("max_limit"));

				gbean.setManager_id(rs.getInt("manager_id"));
				bean.setGbean(gbean);
				
				
				
				
				
				
				
				
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

	public GroupEmployeeBean editData(int employee_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GroupEmployeeBean bean = new GroupEmployeeBean();
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String selectSQL = "Select * from bts.group_employee where employee_id=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, employee_id);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean.setGroup_id(rs.getInt("group_id"));
					bean.setEmployee_id(rs.getInt("employee_id"));

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

	public boolean updateData(GroupEmployeeBean bean,int employee_id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			try {
				String updateSQL = "update bts.group_employee set group_id=?,employee_id=? where employee_id=?";
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setInt(1, bean.getGroup_id());
				pstmt.setInt(2, bean.getEmployee_id());
				pstmt.setInt(3, employee_id);
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
			String deleteSQL = "delete from bts.group_employee where employee_id=?";
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
