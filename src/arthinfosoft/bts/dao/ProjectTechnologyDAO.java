package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.ProjectTechnologyBean;
import arthinfosoft.bts.util.DBConnection1;

public class ProjectTechnologyDAO {

	public boolean insertData(ProjectTechnologyBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String insertSQL = "insert into bts.Project_Technology(Technology_description) values (?) ";

			try {
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, bean.getTechnology_description());
				int result = pstmt.executeUpdate();
				if (result > 0) {
					flag = true;
				} else {
					flag = false;
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

	public boolean deleteData(int id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String deleteSQL = "delete from bts.Project_Technology where Technology_id=?";
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

	public List<ProjectTechnologyBean> listData() {
		List<ProjectTechnologyBean> list = new ArrayList<ProjectTechnologyBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectTechnologyBean bean = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String listSQL = "select * from bts.Project_Technology";

			try {
				pstmt = conn.prepareStatement(listSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new ProjectTechnologyBean();
					bean.setTechnology_id(rs.getInt("Technology_id"));
					bean.setTechnology_description(rs
							.getString("Technology_description"));
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

		}
		return list;
	}

	public ProjectTechnologyBean editData(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectTechnologyBean bean = new ProjectTechnologyBean();
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String editSQL = "Select * from bts.Project_Technology where Technology_id=?";
			try {
				pstmt = conn.prepareStatement(editSQL);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean.setTechnology_id(rs.getInt("Technology_id"));
					bean.setTechnology_description(rs.getString("Technology_description"));

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

	public boolean updateData(ProjectTechnologyBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ProjectTechnologyBean bean1 = new ProjectTechnologyBean();
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String updateSQL = "update bts.Project_Technology set Technology_description=? where Technology_id=?";
			try {
		//		System.out.println(bean.getTechnology_description());
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, bean.getTechnology_description());
				pstmt.setInt(2, bean.getTechnology_id());
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
