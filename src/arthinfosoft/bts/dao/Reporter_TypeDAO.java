package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.Reporter_TypeBean;

import arthinfosoft.bts.util.DBconnection;

public class Reporter_TypeDAO {

	public boolean insertReporter_Type(Reporter_TypeBean bean) {
		
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into bts.Reporter_Type(Reporter_Type_Name) values(?)";

		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, bean.getReporter_type_name());
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

	public List<Reporter_TypeBean> listData() {
		List<Reporter_TypeBean> Reporter_Typelist = new ArrayList<Reporter_TypeBean>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Query = "Select * from bts.Reporter_Type";
		Reporter_TypeBean bean = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {

				pstmt = conn.prepareStatement(Query);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new Reporter_TypeBean();
					bean.setReporter_type_id(rs.getInt(1));
					bean.setReporter_type_name(rs.getString(2));
					Reporter_Typelist.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Reporter_Typelist;
	}

	public boolean deleteData(int id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			String deleteSQL = "delete from bts.Reporter_Type where Reporter_Type_id=?";
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

	public Reporter_TypeBean editData(int id) {
Reporter_TypeBean bean = new Reporter_TypeBean();
		String Query = "select * from bts.Reporter_Type where Reporter_Type_id="+id;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs=null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(Query);
				rs=pstmt.executeQuery();
				rs.next();
					bean.setReporter_type_id(rs.getInt(1));
					bean.setReporter_type_name(rs.getString(2));
				
				
				

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

	public boolean updateData(Reporter_TypeBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBconnection.getConnection();
		if (conn != null) {
			String updateSQL = "update bts.Reporter_Type set Reporter_Type_Name=? where Reporter_Type_id=?";
			try {
		//		System.out.println(bean.getPlatform_description());
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, bean.getReporter_type_name());
				pstmt.setInt(2, bean.getReporter_type_id());
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
	}

	
	
	

