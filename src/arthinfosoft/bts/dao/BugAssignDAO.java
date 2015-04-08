package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.BugAssignBean;
import arthinfosoft.bts.util.DBConnection1;

public class BugAssignDAO {

	public boolean insertData(BugAssignBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String insertSQL;
			try {
				insertSQL = "insert into bts.bug_assign(bug_id,assigned_to,assigned_by,assign_date,is_completed) values(?,?,?,?,?)";
				
				if(bean.getComplete_date()==""){
					pstmt = conn.prepareStatement(insertSQL);
					pstmt.setInt(1,bean.getBug_id());
					pstmt.setInt(2, bean.getAssigned_to());
					pstmt.setInt(3, bean.getAssigned_by());
					pstmt.setString(4, bean.getAssign_date());
					
					pstmt.setString(5, bean.getIs_completed());
						
				}else{
					 insertSQL = "insert into bts.bug_assign(bug_id,assigned_to,assigned_by,assign_date,complete_date,is_completed) values(?,?,?,?,?,?)";
					
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setInt(1,bean.getBug_id());
				pstmt.setInt(2, bean.getAssigned_to());
				pstmt.setInt(3, bean.getAssigned_by());
				pstmt.setString(4, bean.getAssign_date());
				
				pstmt.setString(5, bean.getComplete_date());
				pstmt.setString(6, bean.getIs_completed());
				}
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

	public List<BugAssignBean> listData() {

		List<BugAssignBean> list = new ArrayList<BugAssignBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BugAssignBean bean = null;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String listSQL = "select * from bts.bug_assign a,bts.bug_details b,bts.employee_detail c,bts.employee_detail d where a.bug_id = b.bug_id and a.assigned_to=c.employee_id and a.assigned_by=d.employee_id";
			try {
				pstmt = conn.prepareStatement(listSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new BugAssignBean();
					bean.setBugassign_id(rs.getInt("bug_assign_id"));
					bean.setBug_id(rs.getInt("bug_id"));
					bean.setBug_name(rs.getString("bug_name"));
					bean.setAssigned_to_name(rs.getString("c.employee_firstname")+" "+rs.getString("c.employee_lastname"));
					bean.setAssigned_by_name(rs.getString("d.employee_firstname")+" "+rs.getString("d.employee_lastname"));
					bean.setAssign_date(rs.getString("assign_date"));
					
					bean.setComplete_date(rs.getString("complete_date"));
				
					bean.setIs_completed(rs.getString("is_completed"));
					
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

	public BugAssignBean editData(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BugAssignBean bean = new BugAssignBean();
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String selectSQL = "Select * from bts.bug_assign where bug_assign_id=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean.setBugassign_id(rs.getInt("bug_assign_id"));
					bean.setBug_id(rs.getInt("bug_id"));
					bean.setAssigned_to(rs.getInt("assigned_to"));
					bean.setAssigned_by(rs.getInt("assigned_by"));
					bean.setIs_completed(rs.getString("is_completed"));
					bean.setAssign_date(rs.getString("assign_date"));
					bean.setComplete_date(rs.getString("complete_date"));

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

	public boolean updateData(BugAssignBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String updateSQL;
			try {
			//	System.out.println("bean.getComplete_date():"+bean.getComplete_date());
				updateSQL = "update bts.bug_assign set bug_id=?,assigned_to=?,assigned_by=?,assign_date=?,complete_date=?,is_completed=? where bug_assign_id=?";
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setInt(1, bean.getBug_id());
				pstmt.setInt(2, bean.getAssigned_to());
				pstmt.setInt(3, bean.getAssigned_by());
				pstmt.setString(4, bean.getAssign_date());
				if(bean.getComplete_date().equals("")){
					pstmt.setString(5, null);
				}else{
					pstmt.setString(5, bean.getComplete_date());
				}
				
				pstmt.setString(6, bean.getIs_completed());
				pstmt.setInt(7, bean.getBugassign_id());
		
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
			String deleteSQL = "delete from bts.bug_assign where bug_assign_id=?";
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
