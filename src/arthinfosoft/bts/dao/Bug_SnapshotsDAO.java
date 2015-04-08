package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.Bug_DetailsBean;
import arthinfosoft.bts.bean.Bug_SnapshotsBean;
import arthinfosoft.bts.util.DBconnection;

public class Bug_SnapshotsDAO {
	
public boolean insertBug_Snapshots(Bug_SnapshotsBean bean) {
		
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into bts.Bug_Snapshots(snapshot_description,bug_id) values(?,?)";

		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, bean.getSnapshot_description());
				pstmt.setInt(2, bean.getBug_id());
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

public List<Bug_SnapshotsBean> listData() {
	
	List<Bug_SnapshotsBean> Bug_Snapshotslist = new ArrayList<Bug_SnapshotsBean>();
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String Query = "Select * from bts.Bug_Snapshots a, bts.bug_details b where a.bug_id=b.bug_id";
	Bug_SnapshotsBean bean = null;
	conn = DBconnection.getConnection();
	if (conn != null) {
		try {

			pstmt = conn.prepareStatement(Query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new Bug_SnapshotsBean();
				bean.setSnapshot_id((rs.getInt(1)));
				bean.setBug_id((rs.getInt(2)));
				bean.setSnapshot_description(rs.getString(3));
			//Bug Detils Data
				Bug_DetailsBean bbean = new Bug_DetailsBean();
				bbean.setBug_id(rs.getInt("bug_id"));
				bbean.setTask_id(rs.getInt("task_id"));
				bbean.setBug_name(rs.getString("bug_name"));
				bbean.setBug_status_id(rs.getInt("bug_status_id"));
				bbean.setReporter_type_id(rs.getInt("reporter_type_id"));
				bbean.setReported_by(rs.getInt("reported_by"));
				bbean.setBug_Priority_id(rs.getInt("priority_id"));
				bbean.setReported_date(rs.getString("reported_date"));
				bbean.setBug_type_id(rs.getInt("bug_type_id"));
				
			//main bean
				
				bean.setBbean(bbean);
				
				
				Bug_Snapshotslist.add(bean);
			
			
			
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return Bug_Snapshotslist;
	
}

public Bug_SnapshotsBean editData(int id) {
	Bug_SnapshotsBean bean = new Bug_SnapshotsBean();
	String Query = "select * from bts.Bug_Snapshots where Snapshot_id="+id;
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs=null;
	conn = DBconnection.getConnection();
	if (conn != null) {
		try {
			pstmt = conn.prepareStatement(Query);
			rs=pstmt.executeQuery();
			rs.next();
				bean.setSnapshot_id(rs.getInt(1));
				bean.setBug_id(rs.getInt(2));
				bean.setSnapshot_description(rs.getString(3));
			
		
			

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

public boolean updateData(Bug_SnapshotsBean bean) {

	boolean flag = false;
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	conn = DBconnection.getConnection();
	if (conn != null) {
		String updateSQL = "update bts.Bug_Snapshots set bug_id=?,snapshot_description=? where snapshot_id=?";
		try {
System.out.println(bean.getSnapshot_id());
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setInt(1, bean.getBug_id());
			pstmt.setString(2, bean.getSnapshot_description());
			pstmt.setInt(3, bean.getSnapshot_id());
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
		String deleteSQL = "delete from bts.Bug_Snapshots where snapshot_id=?";
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
