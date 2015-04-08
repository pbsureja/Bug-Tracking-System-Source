package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.util.*;



import arthinfosoft.bts.bean.BugPriorityBean;

public class BugPriorityDAO {

	public boolean insertData(BugPriorityBean bean){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
			String insertSQL="insert into bts.Bug_Priority(bug_priority_description) values (?)";                        
			try {
				pstmt=conn.prepareStatement(insertSQL);
				
				pstmt.setString(1, bean.getBug_priority_description());
				
				int result=pstmt.executeUpdate();
				if(result>0){
					flag=true;
		
				}
				else{
					flag=false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		return flag;
	}
	
	public List<BugPriorityBean> listData(){
		List<BugPriorityBean> list=new ArrayList<BugPriorityBean>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BugPriorityBean bean=null;
		
		conn=DBConnection1.getConnection();
		 if(conn!=null){
		String listSQL="Select * from bts.Bug_Priority";
		try {
			pstmt=conn.prepareStatement(listSQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				bean=new BugPriorityBean();
				
				bean.setBug_priority_id(rs.getInt("bug_priority_id"));
				bean.setBug_priority_description(rs.getString("bug_priority_description"));
				list.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 }
		return list;
	}
	
	
	public boolean deleteData(int id ){
		boolean flag=false;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
		String deleteSQL="delete from bts.Bug_Priority where bug_priority_id=?";	
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

	public BugPriorityBean editData(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BugPriorityBean bean=new BugPriorityBean();
		conn=DBConnection1.getConnection();
		if(conn!=null){
			String selectSQL="Select * from bts.Bug_Priority where bug_priority_id=?"; 
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setInt(1, id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					bean.setBug_priority_id(rs.getInt("bug_priority_id"));
					bean.setBug_priority_description(rs.getString("bug_priority_description"));	
			
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
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
	
	public boolean updateData(BugPriorityBean bean){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
			try {
				String updateSQL="update bts.Bug_Priority set bug_priority_description=? where bug_priority_id=?";
				pstmt=conn.prepareStatement(updateSQL);
				pstmt.setString(1, bean.getBug_priority_description());
				pstmt.setInt(2, bean.getBug_priority_id());
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
