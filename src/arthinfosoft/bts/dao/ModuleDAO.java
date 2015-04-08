package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import arthinfosoft.bts.bean.BugStatusBean;
import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.bean.ModuleBean;
import arthinfosoft.bts.bean.PmtStatusBean;
import arthinfosoft.bts.bean.ProjectBean;
import arthinfosoft.bts.util.DBconnection;

public class ModuleDAO {

	public Boolean insert(ModuleBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into bts.Module(name,code,description,status_id,project_id,estimated_start_date,estimated_end_date,actual_start_date,actual_end_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?,?,?,?)";

		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,bean.getProject_name());
				pstmt.setString(2,bean.getCode());
				pstmt.setString(3,bean.getDescription());
				pstmt.setInt(4,bean.getStatus_id());
				pstmt.setInt(5,bean.getProject_id());
				pstmt.setString(6,bean.getEstimated_start_date());
				pstmt.setString(7,bean.getEstimated_end_date());
				pstmt.setString(8,bean.getActual_start_date());
				pstmt.setString(9,bean.getActual_end_date());
				pstmt.setInt(10,bean.getModified_by());
				pstmt.setString(11,bean.getModified_date());
																						
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

	public List<ModuleBean> listData() {
		List<ModuleBean> modulelist = new ArrayList<ModuleBean>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String Query = "Select * from bts.Module a,bts.pmt_status b,bts.project c,bts.employee_detail d where a.status_id=b.status_id and a.project_id=c.project_id  and a.modified_by=d.employee_id";

		ModuleBean bean = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {

				pstmt = conn.prepareStatement(Query);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new ModuleBean();
					bean.setProject_id(rs.getInt("Project_id"));
					bean.setProject_name(rs.getString("name"));
					bean.setCode(rs.getString("code"));
					bean.setDescription(rs.getString("description"));
					bean.setStatus_id(rs.getInt("status_id"));
					bean.setModule_id(rs.getInt("module_id"));
					bean.setEstimated_start_date(rs.getString("estimated_start_date"));
					bean.setEstimated_end_date(rs.getString("estimated_end_date"));
					bean.setActual_start_date(rs.getString("actual_start_date"));
					bean.setActual_end_date(rs.getString("actual_end_date"));
					bean.setModified_by(rs.getInt("modified_by"));
					bean.setModified_date(rs.getString("modified_date"));
					
					
					//PmtStatus
					
					PmtStatusBean bsbean=new PmtStatusBean();
									
									bsbean.setStatus_id(rs.getInt("status_id"));
									bsbean.setStatus_description(rs.getString("status_description"));
									bean.setBsbean(bsbean);
									
									//Project
									ProjectBean pbean=new ProjectBean();
									pbean.setProject_id(rs.getInt("c.Project_id"));
									pbean.setProject_name(rs.getString("c.name"));
									pbean.setCode(rs.getString("c.code"));
									pbean.setDescription(rs.getString("c.description"));
									pbean.setStatus_id(rs.getInt("c.status_id"));
									pbean.setTechnology_id(rs.getInt("c.technology_id"));
									pbean.setClient_id(rs.getInt("c.client_id"));
									pbean.setEstimated_start_date(rs.getString("c.estimated_start_date"));
									pbean.setEstimated_end_date(rs.getString("c.estimated_end_date"));
									pbean.setActual_start_date(rs.getString("c.actual_start_date"));
									pbean.setActual_end_date(rs.getString("c.actual_end_date"));
									pbean.setModified_by(rs.getInt("c.modified_by"));
									pbean.setModified_date(rs.getString("c.modified_date"));
									
									bean.setPbean(pbean);
									
									
									
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
									

					
								modulelist.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return modulelist;

	
	
	
	
	}

	public ModuleBean editData(String module_id) {
		ModuleBean bean = new ModuleBean();
		String Query = "select * from bts.Module where Module_id="+Integer.parseInt(module_id); 
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
					
				bean.setProject_id(rs.getInt("project_id"));
				bean.setProject_name(rs.getString("name"));
				bean.setCode(rs.getString("code"));
				bean.setDescription(rs.getString("description"));
				bean.setStatus_id(rs.getInt("status_id"));
				bean.setModule_id(rs.getInt("module_id"));
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

	public boolean updateData(ModuleBean bean) {
		
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBconnection.getConnection();
		if (conn != null) {
			String updateSQL = "update bts.Module set name=?,code=?,description=?,status_id=?,project_id=?,estimated_start_date=?,estimated_end_date=?,actual_start_date=?,actual_end_date=?,modified_by=?,modified_date=? where module_id=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);
				System.out.println("name2="+bean.getProject_name());
				pstmt.setString(1,bean.getProject_name());
				pstmt.setString(2,bean.getCode());
				pstmt.setString(3,bean.getDescription());
				pstmt.setInt(4,bean.getStatus_id());
				pstmt.setInt(5,bean.getProject_id());
				
				pstmt.setString(6,bean.getEstimated_start_date());
				pstmt.setString(7,bean.getEstimated_end_date());
				pstmt.setString(8,bean.getActual_start_date());
				pstmt.setString(9,bean.getActual_end_date());
				pstmt.setInt(10,bean.getModified_by());
				pstmt.setString(11,bean.getModified_date());
				pstmt.setInt(12,bean.getProject_id());
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

	public boolean deleteData(int module_id) {

		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			String deleteSQL = "delete from bts.Module where module_id=?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, module_id);
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
