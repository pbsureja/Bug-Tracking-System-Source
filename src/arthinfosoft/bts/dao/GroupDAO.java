package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.bean.GroupBean;
import arthinfosoft.bts.bean.ManagerEmployeeBean;
import arthinfosoft.bts.util.DBConnection1;

public class GroupDAO {

	public boolean insertData(GroupBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String insertSQL = "insert into bts.Group(group_description,max_limit,manager_id) values(?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, bean.getGroup_description());
				pstmt.setInt(2, bean.getMax_limit());
				pstmt.setInt(3, bean.getManager_id());
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

	public List<GroupBean> listData() {

		List<GroupBean> list = new ArrayList<GroupBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		GroupBean bean = null;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String listSQL = "select * from bts.Group a,bts.manager_employee b,bts.employee_detail c where a.manager_id=b.manager_id and b.employee_id=c.employee_id";
			try {
				pstmt = conn.prepareStatement(listSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new GroupBean();
					bean.setGroup_id(rs.getInt("group_id"));
					bean.setGroup_description(rs.getString("group_description"));
					bean.setMax_limit(rs.getInt("max_limit"));

					bean.setManager_id(rs.getInt("manager_id"));
					
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
				
				//Manager_EmployeeDetails
				ManagerEmployeeBean mbean=new  ManagerEmployeeBean();
					mbean.setEmployee_id(rs.getInt("employee_id"));
					mbean.setManager_id(rs.getInt("manager_id"));
					bean.setMbean(mbean);
					
					
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

	public GroupBean editData(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GroupBean bean = new GroupBean();
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String selectSQL = "Select * from bts.Group where group_id=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean.setGroup_id(rs.getInt("group_id"));
					bean.setGroup_description(rs.getString("group_description"));
					bean.setManager_id(rs.getInt("manager_id"));
					bean.setMax_limit(rs.getInt("max_limit"));

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

	public boolean updateData(GroupBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			try {
				String updateSQL = "update bts.Group set group_description=?,max_limit=?,manager_id=? where group_id=?";
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, bean.getGroup_description());
				pstmt.setInt(2, bean.getMax_limit());
				pstmt.setInt(3, bean.getManager_id());
				pstmt.setInt(4, bean.getGroup_id());
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

	public boolean deleteData(int id ){
		boolean flag=false;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
		String deleteSQL="delete from bts.Group where group_id=?";	
		try {
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, id);
			int result=pstmt.executeUpdate();
			if(result>0){
			flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
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
