package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.bean.ManagerEmployeeBean;
import arthinfosoft.bts.util.DBConnection1;

public class ManagerEmployeeDAO {

	public boolean insertData(ManagerEmployeeBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String insertSQL = "insert into bts.manager_employee(employee_id) values(?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setInt(1, bean.getEmployee_id());
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

	public List<ManagerEmployeeBean> listData() {

		List<ManagerEmployeeBean> list = new ArrayList<ManagerEmployeeBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ManagerEmployeeBean bean = null;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String listSQL = "select * from bts.manager_employee a,bts.employee_detail b where a.employee_id = b.employee_id";
			try {
				pstmt = conn.prepareStatement(listSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new ManagerEmployeeBean();
					bean.setManager_id(rs.getInt("manager_id"));
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

	public ManagerEmployeeBean editData(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManagerEmployeeBean bean = new ManagerEmployeeBean();
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String selectSQL = "Select * from bts.manager_employee where manager_id=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean.setManager_id(rs.getInt("manager_id"));
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

	public boolean updateData(ManagerEmployeeBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			try {
				String updateSQL = "update bts.manager_employee set employee_id=? where manager_id=?";
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setInt(2, bean.getManager_id());
				pstmt.setInt(1, bean.getEmployee_id());
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
			String deleteSQL = "delete from bts.manager_employee where manager_id=?";
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
