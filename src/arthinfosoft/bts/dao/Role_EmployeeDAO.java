package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.Role_EmployeeBean;
import arthinfosoft.bts.util.DBconnection;

public class Role_EmployeeDAO {

	public boolean insertRole_Employee(Role_EmployeeBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into bts.Role_Employee(Role_Description) values(?)";

		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, bean.getRole_Description());
				int result = pstmt.executeUpdate();

				if (result > 0) {
					flag = true;

				}

			} catch (SQLException e) {

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

	public List<Role_EmployeeBean> listData() {
		List<Role_EmployeeBean> Role_Employeelist = new ArrayList<Role_EmployeeBean>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Query = "Select * from bts.Role_Employee";
		Role_EmployeeBean bean = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {

				pstmt = conn.prepareStatement(Query);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new Role_EmployeeBean();
					bean.setRole_id(rs.getInt("role_id"));
					bean.setRoll_Description(rs.getString("role_description"));
					Role_Employeelist.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Role_Employeelist;
	}

	public Role_EmployeeBean editRole_Employee(int id) {
		Role_EmployeeBean bean = new Role_EmployeeBean();
		String Query = "select * from bts.Role_Employee where Role_id="+id;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs=null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(Query);
				rs=pstmt.executeQuery();
				rs.next();
				bean.setRole_id(rs.getInt(1));
					bean.setRoll_Description(rs.getString(2));
				
				
				

			} catch (SQLException e) {

				e.printStackTrace();
			}

			finally {

				try {
					pstmt.close();
					rs.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return bean;

	}

	public boolean updateData(Role_EmployeeBean bean) {
	
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBconnection.getConnection();
		if (conn != null) {
			String updateSQL = "update bts.Role_Employee set Role_description=? where Role_id=?";
			try {
		//		System.out.println(bean.getPlatform_description());
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, bean.getRole_Description());
				pstmt.setInt(2, bean.getRole_id());
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

	public boolean deleteData(int id) {
		
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			String deleteSQL = "delete from bts.Role_Employee where Role_id=?";
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

