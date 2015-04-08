package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.util.*;



import arthinfosoft.bts.bean.BugTypeBean;

public class BugTypeDAO {

	public boolean insertData(BugTypeBean bean){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
			String insertSQL="insert into bts.Bug_Type(bug_type_description) values (?)";                        
			try {
				pstmt=conn.prepareStatement(insertSQL);
				
				pstmt.setString(1, bean.getBug_type_description());
				
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
	
	public List<BugTypeBean> listData(){
		List<BugTypeBean> list=new ArrayList<BugTypeBean>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BugTypeBean bean=null;
		
		conn=DBConnection1.getConnection();
		 if(conn!=null){
		String listSQL="Select * from bts.Bug_Type";
		try {
			pstmt=conn.prepareStatement(listSQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				bean=new BugTypeBean();
				
				bean.setBug_type_id(rs.getInt("bug_type_id"));
				bean.setBug_type_description(rs.getString("bug_type_description"));
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
		String deleteSQL="delete from bts.Bug_Type where bug_type_id=?";	
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

	public BugTypeBean editData(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BugTypeBean bean=new BugTypeBean();
		conn=DBConnection1.getConnection();
		if(conn!=null){
			String selectSQL="Select * from bts.Bug_Type where bug_type_id=?"; 
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setInt(1, id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					bean.setBug_type_id(rs.getInt("bug_type_id"));
					bean.setBug_type_description(rs.getString("bug_type_description"));	
			
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
	
	public boolean updateData(BugTypeBean bean){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
			try {
				String updateSQL="update bts.Bug_Type set bug_type_description=? where bug_type_id=?";
				pstmt=conn.prepareStatement(updateSQL);
				pstmt.setString(1, bean.getBug_type_description());
				pstmt.setInt(2, bean.getBug_type_id());
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
