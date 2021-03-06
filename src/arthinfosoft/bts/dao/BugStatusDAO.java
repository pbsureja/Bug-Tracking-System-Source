package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.util.*;



import arthinfosoft.bts.bean.BugStatusBean;

public class BugStatusDAO {

	public boolean insertData(BugStatusBean bean){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
			String insertSQL="insert into bts.Bug_Status(bug_status_description) values (?)";                        
			try {
				pstmt=conn.prepareStatement(insertSQL);
				
				pstmt.setString(1, bean.getBug_status_description());
				
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
	
	public List<BugStatusBean> listData(){
		List<BugStatusBean> list=new ArrayList<BugStatusBean>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BugStatusBean bean=null;
		
		conn=DBConnection1.getConnection();
		 if(conn!=null){
		String listSQL="Select * from bts.Bug_Status";
		try {
			pstmt=conn.prepareStatement(listSQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				bean=new BugStatusBean();
				
				bean.setBug_status_id(rs.getInt("bug_status_id"));
				bean.setBug_status_description(rs.getString("bug_status_description"));
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
		String deleteSQL="delete from bts.Bug_Status where bug_status_id=?";	
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

	public BugStatusBean editData(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BugStatusBean bean=new BugStatusBean();
		conn=DBConnection1.getConnection();
		if(conn!=null){
			String selectSQL="Select * from bts.Bug_Status where bug_status_id=?"; 
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setInt(1, id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					bean.setBug_status_id(rs.getInt("bug_status_id"));
					bean.setBug_status_description(rs.getString("bug_status_description"));	
			
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
	
	public boolean updateData(BugStatusBean bean){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
			try {
				String updateSQL="update bts.Bug_Status set bug_status_description=? where bug_status_id=?";
				pstmt=conn.prepareStatement(updateSQL);
				pstmt.setString(1, bean.getBug_status_description());
				pstmt.setInt(2, bean.getBug_status_id());
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
