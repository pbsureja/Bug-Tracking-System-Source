package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.DepartmentBean;
import arthinfosoft.bts.util.DBConnection1;

public class DepartmentDAO {

	public boolean insertData(DepartmentBean bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String insertSQL = "insert into bts.Department(department_description,max_limit,manager_id) values(?,?,?)";
			try {
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, bean.getDepartment_description());
				pstmt.setInt(2, bean.getMax_limit());
				pstmt.setInt(3, bean.getManager_id());
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

	public List<DepartmentBean> listData() {

		List<DepartmentBean> list = new ArrayList<DepartmentBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		DepartmentBean bean = null;
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String listSQL = "select * from bts.Department a,bts.manager_employee b,bts.employee_detail c where a.manager_id=b.manager_id and b.employee_id=c.employee_id";
			try {
				pstmt = conn.prepareStatement(listSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new DepartmentBean();
					bean.setDepartment_id(rs.getInt("department_id"));
					bean.setDepartment_description(rs.getString("department_description"));
					bean.setMax_limit(rs.getInt("max_limit"));
bean.setManager_name(rs.getString("c.employee_firstname")+" "+rs.getString("c.employee_lastname"));
					bean.setManager_id(rs.getInt("manager_id"));
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

	public DepartmentBean editData(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DepartmentBean bean = new DepartmentBean();
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String selectSQL = "Select * from bts.Department where department_id=?";
			try {
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					bean.setDepartment_id(rs.getInt("department_id"));
					bean.setDepartment_description(rs.getString("department_description"));
					bean.setManager_id(rs.getInt("manager_id"));
					bean.setMax_limit(rs.getInt("max_limit"));

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

	public boolean updateData(DepartmentBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			try {
				String updateSQL = "update bts.Department set department_description=?,max_limit=?,manager_id=? where department_id=?";
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, bean.getDepartment_description());
				pstmt.setInt(2, bean.getMax_limit());
				pstmt.setInt(3, bean.getManager_id());
				pstmt.setInt(4, bean.getDepartment_id());
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

	public boolean deleteData(int id ){
		boolean flag=false;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBConnection1.getConnection();
		if(conn!=null){
		String deleteSQL="delete from bts.Department where department_id=?";	
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

}
