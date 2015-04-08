package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.BugStatusBean;
import arthinfosoft.bts.bean.Client_DetailsBean;
import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.bean.PmtStatusBean;
import arthinfosoft.bts.bean.ProjectBean;
import arthinfosoft.bts.bean.ProjectPlatformBean;
import arthinfosoft.bts.bean.ProjectTechnologyBean;
import arthinfosoft.bts.util.DBconnection;

public class ProjectDAO {

	public Boolean insert(ProjectBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into bts.Project(name,code,description,status_id,technology_id,platform_id,client_id,estimated_start_date,estimated_end_date,actual_start_date,actual_end_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,bean.getProject_name());
				pstmt.setString(2,bean.getCode());
				pstmt.setString(3,bean.getDescription());
				pstmt.setInt(4,bean.getStatus_id());
				pstmt.setInt(5,bean.getTechnology_id());
				pstmt.setInt(6,bean.getPlatform_id());
				pstmt.setInt(7,bean.getClient_id());
				pstmt.setString(8,bean.getEstimated_start_date());
				pstmt.setString(9,bean.getEstimated_end_date());
				pstmt.setString(10,bean.getActual_start_date());
				pstmt.setString(11,bean.getActual_end_date());
				pstmt.setInt(12,bean.getModified_by());
				pstmt.setString(13,bean.getModified_date());
				
								
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

	public List<ProjectBean> listData() {
		List<ProjectBean> projectlist = new ArrayList<ProjectBean>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Query = "Select * from bts.Project a,bts.pmt_status b,bts.project_technology c,bts.project_platform d,bts.client_details e,bts.employee_detail f where a.status_id=b.status_id and a.technology_id=c.technology_id and a.platform_id=d.platform_id and a.client_id =e.client_details_id and a.modified_by=f.employee_id";
		ProjectBean bean = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {

				pstmt = conn.prepareStatement(Query);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new ProjectBean();
					bean.setProject_id(rs.getInt("Project_id"));
					bean.setProject_name(rs.getString("name"));
					bean.setCode(rs.getString("code"));
					bean.setDescription(rs.getString("description"));
					bean.setStatus_id(rs.getInt("status_id"));
					bean.setTechnology_id(rs.getInt("technology_id"));
					bean.setPlatform_id(rs.getInt("platform_id"));
					bean.setClient_id(rs.getInt("client_id"));
					bean.setEstimated_start_date(rs.getString("estimated_start_date"));
					bean.setEstimated_end_date(rs.getString("estimated_end_date"));
					bean.setActual_start_date(rs.getString("actual_start_date"));
					bean.setActual_end_date(rs.getString("actual_end_date"));
					bean.setModified_by(rs.getInt("modified_by"));
					bean.setModified_date(rs.getString("modified_date"));
				
					//Bug_Status
					
	PmtStatusBean bsbean=new PmtStatusBean();
					
					bsbean.setStatus_id(rs.getInt("b.status_id"));
					bsbean.setStatus_description(rs.getString("status_description"));
					bean.setBsbean(bsbean);
					
					//Project_Technology
					ProjectTechnologyBean ptbean = new ProjectTechnologyBean();
					ptbean.setTechnology_id(rs.getInt("Technology_id"));
					ptbean.setTechnology_description(rs.getString("Technology_description"));
					bean.setPtbean(ptbean);
					//Bug_Platform
					ProjectPlatformBean ppbean = new ProjectPlatformBean();
					ppbean.setPlatform_id(rs.getInt("Platform_id"));
					ppbean.setPlatform_description(rs.getString("Platform_description"));
					bean.setPpbean(ppbean);
					//ClientDetails
					Client_DetailsBean cbean = new Client_DetailsBean();
					cbean.setClient_id(rs.getInt("client_details_id"));
					cbean.setClient_name(rs.getString("client_details_name"));
					cbean.setPassword(rs.getString("client_details_password"));
					cbean.setSecurityquestion(rs.getString("client_details_securityquestion"));
					cbean.setAnswer(rs.getString("client_details_answer"));
					cbean.setPhone_no(rs.getString("client_details_phone_no"));
					cbean.setAddress(rs.getString("client_details_address"));
					cbean.setFax(rs.getString("client_details_fax"));
					cbean.setWebsite(rs.getString("client_details_website"));
					bean.setCbean(cbean);
					
					//Modified By--Employee Details
					
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
					
					
					
					projectlist.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return projectlist;

	
	
	
	
	}

	public ProjectBean editData(String project_id) {
		ProjectBean bean = new ProjectBean();
		String Query = "select * from bts.project where project_id="+Integer.parseInt(project_id); 
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs=null;
		int a=0;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(Query);
				rs=pstmt.executeQuery();
				rs.next();
					
				bean.setProject_id(rs.getInt("Project_id"));
				System.out.println(rs.getInt("Project_id"));
				bean.setProject_name(rs.getString("name"));
				bean.setCode(rs.getString("code"));
				bean.setDescription(rs.getString("description"));
				bean.setStatus_id(rs.getInt("status_id"));
				bean.setTechnology_id(rs.getInt("technology_id"));
				bean.setPlatform_id(rs.getInt("platform_id"));
				bean.setClient_id(rs.getInt("client_id"));
				bean.setEstimated_start_date(rs.getString("estimated_start_date"));
				bean.setEstimated_end_date(rs.getString("estimated_end_date"));
				bean.setActual_start_date(rs.getString("actual_start_date"));
				bean.setActual_end_date(rs.getString("actual_end_date"));
				bean.setModified_by(rs.getInt("modified_by"));
				bean.setModified_date(rs.getString("modified_date"));
		
					
				
						
				

			} catch (SQLException e) {
System.out.println(a);
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
		else{
			return null;
		}

	
	
	
	
	}

	public boolean updateData(ProjectBean bean) {
		
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBconnection.getConnection();
		if (conn != null) {
			String updateSQL = "update bts.project set name=?,code=?,description=?,status_id=?,technology_id=?,platform_id=?,client_id=?,estimated_start_date=?,estimated_end_date=?,actual_start_date=?,actual_end_date=?,modified_by=?,modified_date=? where project_id=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);
				System.out.println("name2="+bean.getProject_name());
				pstmt.setString(1,bean.getProject_name());
				pstmt.setString(2,bean.getCode());
				pstmt.setString(3,bean.getDescription());
				pstmt.setInt(4,bean.getStatus_id());
				pstmt.setInt(5,bean.getTechnology_id());
				pstmt.setInt(6,bean.getPlatform_id());
				pstmt.setInt(7,bean.getClient_id());
				pstmt.setString(8,bean.getEstimated_start_date());
				pstmt.setString(9,bean.getEstimated_end_date());
				pstmt.setString(10,bean.getActual_start_date());
				pstmt.setString(11,bean.getActual_end_date());
				pstmt.setInt(12,bean.getModified_by());
				pstmt.setString(13,bean.getModified_date());
				pstmt.setInt(14,bean.getProject_id());
				System.out.println("id="+bean.getProject_id());
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

	public boolean deleteData(int project_id) {

		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			String deleteSQL = "delete from bts.Project where project_id=?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, project_id);
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
