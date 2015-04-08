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
import arthinfosoft.bts.bean.TaskBean;
import arthinfosoft.bts.util.DBconnection;

public class TaskDAO {

	public Boolean insert(TaskBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into bts.Task(name,code,description,status_id,module_id,client_id,estimated_start_date,estimated_end_date,actual_start_date,actual_end_date,modified_by,modified_date) values(?,?,?,?,?,?,?,?,?,?,?,?)";

		conn = DBconnection.getConnection();
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1,bean.getProject_name());
				pstmt.setString(2,bean.getCode());
				pstmt.setString(3,bean.getDescription());
				pstmt.setInt(4,bean.getStatus_id());
				pstmt.setInt(5,bean.getModule_id());
				pstmt.setInt(6,bean.getClient_id());
				pstmt.setString(7,bean.getEstimated_start_date());
				pstmt.setString(8,bean.getEstimated_end_date());
				pstmt.setString(9,bean.getActual_start_date());
				pstmt.setString(10,bean.getActual_end_date());
				pstmt.setInt(11,bean.getModified_by());
				pstmt.setString(12,bean.getModified_date());
																						
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

	public List<TaskBean> listData() {
		List<TaskBean> tasklist = new ArrayList<TaskBean>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String Query = "Select * from bts.Task a,bts.Pmt_Status b,bts.Module c,bts.Employee_Detail d,bts.Project e where a.status_id=b.status_id and a.module_id=c.module_id and a.modified_by=d.employee_id and c.project_id=e.project_id";
		TaskBean bean = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			try {

				pstmt = conn.prepareStatement(Query);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean = new TaskBean();
					bean.setTask_id(rs.getInt("a.task_id"));
					bean.setProject_name(rs.getString("a.name"));
					bean.setDescription(rs.getString("a.description"));
					bean.setStatus_id(rs.getInt("a.status_id"));
					bean.setModule_id(rs.getInt("a.module_id"));
					bean.setEstimated_start_date(rs.getString("a.estimated_start_date"));
					bean.setEstimated_end_date(rs.getString("a.estimated_end_date"));
					bean.setActual_start_date(rs.getString("a.actual_start_date"));
					bean.setActual_end_date(rs.getString("a.actual_end_date"));
					bean.setModified_by(rs.getInt("a.modified_by"));
					bean.setModified_date(rs.getString("a.modified_date"));
					
				
				//Pmt_Status Bean
					PmtStatusBean bsbean=new PmtStatusBean();
					
					bsbean.setStatus_id(rs.getInt("b.status_id"));
					bsbean.setStatus_description(rs.getString("b.status_description"));
					bean.setBsbean(bsbean);
					
					
					//Module Bean
					ModuleBean mbean = new ModuleBean();
					mbean.setProject_id(rs.getInt("c.Project_id"));
					mbean.setProject_name(rs.getString("c.name"));
					mbean.setCode(rs.getString("c.code"));
					mbean.setDescription(rs.getString("c.description"));
					mbean.setStatus_id(rs.getInt("c.status_id"));
					mbean.setModule_id(rs.getInt("c.module_id"));
					mbean.setEstimated_start_date(rs.getString("c.estimated_start_date"));
					mbean.setEstimated_end_date(rs.getString("c.estimated_end_date"));
					mbean.setActual_start_date(rs.getString("c.actual_start_date"));
					mbean.setActual_end_date(rs.getString("c.actual_end_date"));
					mbean.setModified_by(rs.getInt("c.modified_by"));
					mbean.setModified_date(rs.getString("c.modified_date"));
					bean.setMbean(mbean);
					
					//Employee Bean

					EmployeeDetailBean ebean = new EmployeeDetailBean();
					ebean.setEmployee_id(rs.getInt("d.employee_id"));
					ebean.setEmail(rs.getString("d.email"));
					ebean.setPassword(rs.getString("d.password"));
					ebean.setSecurity_question(rs.getString("d.security_question"));
					ebean.setAnswer(rs.getString("d.answer"));
					ebean.setEmployee_firstname(rs.getString("d.employee_firstname"));
					ebean.setEmployee_lastname(rs.getString("d.employee_lastname"));
					ebean.setPermanent_address(rs.getString("d.permanent_address"));
					ebean.setTemporary_address(rs.getString("d.temporary_address"));
					ebean.setMobile(rs.getString("d.mobile"));
					ebean.setLandline(rs.getString("d.landline"));
					ebean.setDateofbirth(rs.getString("d.dateofbirth"));
					ebean.setDesignation(rs.getInt("d.designation"));
					ebean.setJoining_date(rs.getString("d.joining_date"));
					ebean.setIs_active(rs.getString("d.is_active"));
					ebean.setRole_id(rs.getInt("d.role_id"));
					ebean.setdepartment_id(rs.getInt("d.department_id"));
					ebean.setManager_id(rs.getInt("d.manager_id"));
					ebean.setSalary(rs.getInt("d.salary"));
				bean.setEbean(ebean);
				
				
				//Project Bean
				ProjectBean pbean=new ProjectBean();
				pbean.setProject_id(rs.getInt("e.Project_id"));
				pbean.setProject_name(rs.getString("e.name"));
				pbean.setCode(rs.getString("e.code"));
				pbean.setDescription(rs.getString("e.description"));
				pbean.setStatus_id(rs.getInt("e.status_id"));
				pbean.setTechnology_id(rs.getInt("e.technology_id"));
				pbean.setClient_id(rs.getInt("e.client_id"));
				pbean.setEstimated_start_date(rs.getString("e.estimated_start_date"));
				pbean.setEstimated_end_date(rs.getString("e.estimated_end_date"));
				pbean.setActual_start_date(rs.getString("e.actual_start_date"));
				pbean.setActual_end_date(rs.getString("e.actual_end_date"));
				pbean.setModified_by(rs.getInt("e.modified_by"));
				pbean.setModified_date(rs.getString("e.modified_date"));
				
				bean.setPbean(pbean);
				tasklist.add(bean);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return tasklist;

	
	
	
	
	}

	public TaskBean editData(String task_id) {
		TaskBean bean = new TaskBean();
		String Query = "select * from bts.task where task_id="+Integer.parseInt(task_id); 
		System.out.println("QUERY="+Query);
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
					
			//	bean.setTask_id(rs.getInt("task_id"));
				bean.setProject_name(rs.getString("name"));
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

	public boolean updateData(TaskBean bean) {
		
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBconnection.getConnection();
		if (conn != null) {
			String updateSQL = "update bts.task set name=?,code=?,description=?,status_id=?,module_id=?,client_id=?,estimated_start_date=?,estimated_end_date=?,actual_start_date=?,actual_end_date=?,modified_by=?,modified_date=? where task_id=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1,bean.getProject_name());
				pstmt.setString(2,bean.getCode());
				pstmt.setString(3,bean.getDescription());
				pstmt.setInt(4,bean.getStatus_id());
				pstmt.setInt(5,bean.getModule_id());
				pstmt.setInt(6,bean.getClient_id());
				pstmt.setString(7,bean.getEstimated_start_date());
				pstmt.setString(8,bean.getEstimated_end_date());
				pstmt.setString(9,bean.getActual_start_date());
				pstmt.setString(10,bean.getActual_end_date());
				pstmt.setInt(11,bean.getModified_by());
				pstmt.setString(12,bean.getModified_date());
				pstmt.setInt(13,bean.getTask_id());
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

	public boolean deleteData(int task_id) {

		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBconnection.getConnection();
		if (conn != null) {
			String deleteSQL = "delete from bts.Task where task_id=?";
			try {
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, task_id);
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
