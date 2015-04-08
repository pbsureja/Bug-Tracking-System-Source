package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.Client_DetailsBean;
import arthinfosoft.bts.util.DBconnection;

public class Client_DetailsDAO {

	public boolean insertClient_Details(Client_DetailsBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into bts.Client_Details(client_details_name,client_details_password,client_details_securityquestion,client_details_answer,client_details_phone_no,client_details_address,client_details_fax,client_details_website,client_details_email) values(?,?,?,?,?,?,?,?,?)";

		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1,bean.getClient_name());
				pstmt.setString(2,bean.getPassword());
				pstmt.setString(3,bean.getSecurityquestion());
				pstmt.setString(4,bean.getAnswer());
				pstmt.setString(5,bean.getPhone_no());
				pstmt.setString(6,bean.getAddress());
				pstmt.setString(7,bean.getFax());
				pstmt.setString(8,bean.getWebsite());
				pstmt.setString(9, bean.getEmail());
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

	public List<Client_DetailsBean> listData() {
		List<Client_DetailsBean> Client_Detailslist = new ArrayList<Client_DetailsBean>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Query = "Select * from bts.Client_Details";
		Client_DetailsBean cbean = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {

				pstmt = conn.prepareStatement(Query);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					cbean = new Client_DetailsBean();
					cbean.setClient_id(rs.getInt("client_details_id"));
					cbean.setClient_name(rs.getString("client_details_name"));
					cbean.setPassword(rs.getString("client_details_password"));
					cbean.setSecurityquestion(rs.getString("client_details_securityquestion"));
					cbean.setAnswer(rs.getString("client_details_answer"));
					cbean.setPhone_no(rs.getString("client_details_phone_no"));
					cbean.setAddress(rs.getString("client_details_address"));
					cbean.setFax(rs.getString("client_details_fax"));
					cbean.setWebsite(rs.getString("client_details_website"));
					cbean.setEmail(rs.getString("client_details_email"));
					Client_Detailslist.add(cbean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Client_Detailslist;
	}

	
public boolean deleteData(int id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			String deleteSQL = "delete from bts.Client_Details where Client_Details_id=?";
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

public Client_DetailsBean editData(int id) {
	
	Client_DetailsBean cbean = new Client_DetailsBean();
	String Query = "select * from bts.Client_Details where Client_Details_id="+id;
	PreparedStatement pstmt = null;
	Connection conn = null;
	ResultSet rs=null;
	conn = DBconnection.getConnection();
	if (conn != null) {
		try {
			pstmt = conn.prepareStatement(Query);
			rs=pstmt.executeQuery();
			rs.next();
				
			cbean.setClient_id(rs.getInt("client_details_id"));
			cbean.setClient_name(rs.getString("client_details_name"));
			cbean.setPassword(rs.getString("client_details_password"));
			cbean.setSecurityquestion(rs.getString("client_details_securityquestion"));
			cbean.setAnswer(rs.getString("client_details_answer"));
			cbean.setPhone_no(rs.getString("client_details_phone_no"));
			cbean.setAddress(rs.getString("client_details_address"));
			cbean.setFax(rs.getString("client_details_fax"));
			cbean.setWebsite(rs.getString("client_details_website"));
			cbean.setEmail(rs.getString("client_details_email"));
							
				
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

	return cbean;
	
}

public boolean updateData(Client_DetailsBean bean) {
	
	boolean flag = false;
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	conn = DBconnection.getConnection();
	if (conn != null) {
		String updateSQL = "update bts.Client_Details set Client_Details_Name=?,Client_Details_Password=?,Client_Details_SecurityQuestion=?,Client_Details_Answer=?,Client_Details_Phone_No=?,Client_Details_Address=?,Client_Details_Fax=?,Client_Details_Website=?,client_details_email=?  where Client_Details_id=?";
		try {
	//		System.out.println(bean.getPlatform_description());
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1,bean.getClient_name());
			pstmt.setString(2,bean.getPassword());
			pstmt.setString(3,bean.getSecurityquestion());
			pstmt.setString(4,bean.getAnswer());
			pstmt.setString(5,bean.getPhone_no());
			pstmt.setString(6,bean.getAddress());
			pstmt.setString(7,bean.getFax());
			pstmt.setString(8,bean.getWebsite());
			pstmt.setInt(10,bean.getClient_id());
			pstmt.setString(9, bean.getEmail());
			
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

