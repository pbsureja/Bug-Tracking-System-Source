package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.bean.TaskAssignBean;
import arthinfosoft.bts.bean.TaskBean;
import arthinfosoft.bts.util.DBConnection1;

public class TaskAssignDAO {

	public boolean insertData(TaskAssignBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		conn = DBConnection1.getConnection();

		String insertSQL;
		if (conn != null) {
			 try {
				
				insertSQL = "insert into bts.task_assign(task_id,assigned_to,assigned_by,assign_date,complete_date,is_completed) values(?,?,?,?,?,?)";
						
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setInt(1,bean.getTask_id());
				pstmt.setInt(2, bean.getAssigned_to());
				pstmt.setInt(3, bean.getAssigned_by());
				pstmt.setString(4, bean.getAssign_date());
				if(bean.getComplete_date().equals("")){
					pstmt.setString(5, null);
				}else{
					pstmt.setString(5, bean.getComplete_date());
				}pstmt.setString(6, bean.getIs_completed());
				
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
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return flag;
	}	

	public List<TaskAssignBean> listData() {

		List<TaskAssignBean> list = new ArrayList<TaskAssignBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		TaskAssignBean bean = null;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String listSQL = "select * from bts.task_assign a,bts.employee_detail b,bts.task c,bts.employee_detail d where a.task_id=c.task_id and a.assigned_to=b.employee_id and a.assigned_by=d.employee_id";
			try {
				pstmt = conn.prepareStatement(listSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new TaskAssignBean();
					bean.setTaskassign_id(rs.getInt("task_assign_id"));
					bean.setTask_id(rs.getInt("task_id"));
					bean.setAssigned_to(rs.getInt("assigned_to"));
					bean.setAssigned_by(rs.getInt("assigned_by"));
					bean.setAssign_date(rs.getString("assign_date"));
					bean.setComplete_date(rs.getString("complete_date"));
					bean.setIs_completed(rs.getString("is_completed"));
					
					
					
					//Employee Details for assigned by
					
					EmployeeDetailBean ebean = new EmployeeDetailBean();
					ebean.setEmployee_id(rs.getInt("b.employee_id"));
					ebean.setEmail(rs.getString("b.email"));
					ebean.setPassword(rs.getString("b.password"));
					ebean.setSecurity_question(rs.getString("b.security_question"));
					ebean.setAnswer(rs.getString("b.answer"));
					ebean.setEmployee_firstname(rs.getString("b.employee_firstname"));
					ebean.setEmployee_lastname(rs.getString("b.employee_lastname"));
					ebean.setPermanent_address(rs.getString("b.permanent_address"));
					ebean.setTemporary_address(rs.getString("b.temporary_address"));
					ebean.setMobile(rs.getString("b.mobile"));
					ebean.setLandline(rs.getString("b.landline"));
					ebean.setDateofbirth(rs.getString("b.dateofbirth"));
					ebean.setDesignation(rs.getInt("b.designation"));
					ebean.setJoining_date(rs.getString("b.joining_date"));
					ebean.setIs_active(rs.getString("b.is_active"));
					ebean.setRole_id(rs.getInt("b.role_id"));
					ebean.setdepartment_id(rs.getInt("b.department_id"));
					ebean.setManager_id(rs.getInt("b.manager_id"));
					ebean.setSalary(rs.getInt("b.salary"));
					
					
					bean.setEbean(ebean);
					
					

					//Employee Details for assigned to
					
					EmployeeDetailBean ebean2 = new EmployeeDetailBean();
					ebean2.setEmployee_id(rs.getInt("d.employee_id"));
					ebean2.setEmail(rs.getString("d.email"));
					ebean2.setPassword(rs.getString("d.password"));
					ebean2.setSecurity_question(rs.getString("d.security_question"));
					ebean2.setAnswer(rs.getString("d.answer"));
					ebean2.setEmployee_firstname(rs.getString("d.employee_firstname"));
					ebean2.setEmployee_lastname(rs.getString("d.employee_lastname"));
					ebean2.setPermanent_address(rs.getString("d.permanent_address"));
					ebean2.setTemporary_address(rs.getString("d.temporary_address"));
					ebean2.setMobile(rs.getString("d.mobile"));
					ebean2.setLandline(rs.getString("d.landline"));
					ebean2.setDateofbirth(rs.getString("d.dateofbirth"));
					ebean2.setDesignation(rs.getInt("d.designation"));
					ebean2.setJoining_date(rs.getString("d.joining_date"));
					ebean2.setIs_active(rs.getString("d.is_active"));
					ebean2.setRole_id(rs.getInt("d.role_id"));
					ebean2.setdepartment_id(rs.getInt("d.department_id"));
					ebean2.setManager_id(rs.getInt("d.manager_id"));
					ebean2.setSalary(rs.getInt("d.salary"));
					
					bean.setEbean2(ebean2);
					
					
					
					//Task Bean
					
					TaskBean tbean = new TaskBean();
					tbean.setTask_id(rs.getInt("task_id"));
					tbean.setProject_name(rs.getString("name"));
					tbean.setDescription(rs.getString("description"));
					tbean.setStatus_id(rs.getInt("status_id"));
					tbean.setModule_id(rs.getInt("module_id"));
					tbean.setEstimated_start_date(rs.getString("estimated_start_date"));
					tbean.setEstimated_end_date(rs.getString("estimated_end_date"));
					tbean.setActual_start_date(rs.getString("actual_start_date"));
					tbean.setActual_end_date(rs.getString("actual_end_date"));
					tbean.setModified_by(rs.getInt("modified_by"));
					tbean.setModified_date(rs.getString("modified_date"));
					bean.setTbean(tbean);	
					
					
					list.add(bean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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
		return list;
	}

	public TaskAssignBean editData(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TaskAssignBean bean = new TaskAssignBean();
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String selectSQL = "Select * from bts.task_assign where task_assign_id=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean.setTaskassign_id(rs.getInt("task_assign_id"));
					bean.setTask_id(rs.getInt("task_id"));
					bean.setAssigned_to(rs.getInt("assigned_to"));
					bean.setAssigned_by(rs.getInt("assigned_by"));
					bean.setIs_completed(rs.getString("is_completed"));
					bean.setAssign_date(rs.getString("assign_date"));
					bean.setComplete_date(rs.getString("complete_date"));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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

	public boolean updateData(TaskAssignBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			try {
				String updateSQL = "update bts.task_assign set task_id=?,assigned_to=?,assigned_by=?,assign_date=?,complete_date=?,is_completed=? where task_assign_id=?";
				pstmt = conn.prepareStatement(updateSQL);
				
				pstmt.setInt(1, bean.getTask_id());
				pstmt.setInt(2, bean.getAssigned_to());
				pstmt.setInt(3, bean.getAssigned_by());
				pstmt.setString(4, bean.getAssign_date());
				if(bean.getComplete_date().equals("")){
					pstmt.setString(5, null);
				}else{
					pstmt.setString(5, bean.getComplete_date());
				}pstmt.setString(6, bean.getIs_completed());
				pstmt.setInt(7, bean.getTaskassign_id());
				
				int result = pstmt.executeUpdate();
				if (result > 0) {
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally {
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

	public boolean deleteData(int id) {
		boolean flag = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String deleteSQL = "delete from bts.task_assign where task_assign_id=?";
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

}
