package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.Bug_DetailsBean;
import arthinfosoft.bts.util.DBconnection;

public class Bug_DetailsDAO {

	public Boolean insert(Bug_DetailsBean bean) {

		
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into bts.Bug_Details(task_id,bug_name,bug_status_id,reporter_type_id,reported_by,priority_id,reported_date,bug_type_id) values(?,?,?,?,?,?,?,?)";
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, bean.getTask_id());
				pstmt.setString(2, bean.getBug_name());
				pstmt.setInt(3, bean.getBug_status_id());
				pstmt.setInt(4, bean.getReporter_type_id());
				pstmt.setInt(5, bean.getReported_by());
				pstmt.setInt(6, bean.getBug_Priority_id());
				pstmt.setString(7, bean.getReported_date());
				pstmt.setInt(8, bean.getBug_type_id());
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

	public List<Bug_DetailsBean> listData() {

		List<Bug_DetailsBean> Bug_Detailslist = new ArrayList<Bug_DetailsBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Query = "Select * from bts.Bug_Details a,bts.task b,bts.bug_status c,bts.reporter_type d,bts.bug_priority e,bts.bug_type f,bts.employee_detail g where a.task_id=b.task_id and a.bug_status_id=c.bug_status_id and a.reporter_type_id= d.reporter_type_id and a.reported_by=g.employee_id and a.priority_id=e.bug_priority_id and a.bug_type_id=f.bug_type_id";
		Bug_DetailsBean bean = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {

				pstmt = conn.prepareStatement(Query);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new Bug_DetailsBean();
					bean.setBug_id(rs.getInt("bug_id"));
					bean.setTask_id(rs.getInt("task_id"));
					bean.setTask(rs.getString("b.name"));
					bean.setBug_name(rs.getString("bug_name"));
					bean.setBug_status_id(rs.getInt("bug_status_id"));
					bean.setBug_status(rs.getString("c.bug_status_description"));
					bean.setReporter_type_id(rs.getInt("reporter_type_id"));
					bean.setReporter_type_name(rs.getString("reporter_type_name"));
					bean.setReported_by(rs.getInt("reported_by"));
					bean.setReporter(rs.getString("g.employee_firstname")+" "+rs.getString("g.employee_lastname"));
					bean.setBug_Priority_id(rs.getInt("priority_id"));
					bean.setPriority(rs.getString("bug_priority_description"));
					bean.setReported_date(rs.getString("reported_date"));
					bean.setBug_type_id(rs.getInt("bug_type_id"));
					bean.setBug_type_name(rs.getString("bug_type_description"));
					Bug_Detailslist.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Bug_Detailslist;

	
	}

	public Bug_DetailsBean editData(int id) {

		Bug_DetailsBean bean = new Bug_DetailsBean();
		String Query = "select * from bts.Bug_Details where bug_id="+id;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs=null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(Query);
				rs=pstmt.executeQuery();
				rs.next();
				bean = new Bug_DetailsBean();
				bean.setBug_id(rs.getInt("bug_id"));
				bean.setTask_id(rs.getInt("task_id"));
				bean.setBug_name(rs.getString("bug_name"));
				bean.setBug_status_id(rs.getInt("bug_status_id"));
				bean.setReporter_type_id(rs.getInt("reporter_type_id"));
				bean.setReported_by(rs.getInt("reported_by"));
				bean.setBug_Priority_id(rs.getInt("priority_id"));
				bean.setReported_date(rs.getString("reported_date"));
				bean.setBug_type_id(rs.getInt("bug_type_id"));
			
				

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

		if(bean!=null){
		return bean;
		}
		
return null;
	
	
	}

	public Boolean update(Bug_DetailsBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "update bts.Bug_Details set task_id=?,bug_name=?,bug_status_id=?,reporter_type_id=?,reported_by=?,priority_id=?,reported_date=?,bug_type_id=? where bug_id=?";
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, bean.getTask_id());
				pstmt.setString(2, bean.getBug_name());
				pstmt.setInt(3, bean.getBug_status_id());
				pstmt.setInt(4, bean.getReporter_type_id());
				pstmt.setInt(5, bean.getReported_by());
				pstmt.setInt(6, bean.getBug_Priority_id());
				pstmt.setString(7, bean.getReported_date());
				pstmt.setInt(8, bean.getBug_type_id());
				pstmt.setInt(9, bean.getBug_id());
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

	public boolean deleteData(int snapshot_id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			String deleteSQL = "delete from bts.Bug_Details where bug_id=?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, snapshot_id);
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


