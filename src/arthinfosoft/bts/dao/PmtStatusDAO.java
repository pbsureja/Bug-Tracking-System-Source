package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.util.*;



import arthinfosoft.bts.bean.PmtStatusBean;

public class PmtStatusDAO {

	public boolean insertData(PmtStatusBean bean){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
			String insertSQL="insert into bts.pmt_status(status_description) values (?)";                        
			try {
				pstmt=conn.prepareStatement(insertSQL);
				
				pstmt.setString(1, bean.getStatus_description());
				
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
	
	public List<PmtStatusBean> listData(){
		List<PmtStatusBean> list=new ArrayList<PmtStatusBean>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PmtStatusBean bean=null;
		
		conn=DBConnection1.getConnection();
		 if(conn!=null){
		String listSQL="Select * from bts.pmt_status";
		try {
			pstmt=conn.prepareStatement(listSQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				bean=new PmtStatusBean();
				
				bean.setStatus_id(rs.getInt("status_id"));
				bean.setStatus_description(rs.getString("status_description"));
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
		String deleteSQL="delete from bts.pmt_status where status_id=?";	
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

	public PmtStatusBean editData(int id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		PmtStatusBean bean=new PmtStatusBean();
		conn=DBConnection1.getConnection();
		if(conn!=null){
			String selectSQL="Select * from bts.pmt_status where status_id=?"; 
			try {
				pstmt=conn.prepareStatement(selectSQL);
				pstmt.setInt(1, id);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					bean.setStatus_id(rs.getInt("status_id"));
					bean.setStatus_description(rs.getString("status_description"));	
			
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
	
	public boolean updateData(PmtStatusBean bean){
		boolean flag=false;
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
			try {
				String updateSQL="update bts.pmt_status set status_description=? where status_id=?";
				pstmt=conn.prepareStatement(updateSQL);
				pstmt.setString(1, bean.getStatus_description());
				pstmt.setInt(2, bean.getStatus_id());
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
