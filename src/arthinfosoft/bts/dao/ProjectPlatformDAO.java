package arthinfosoft.bts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import arthinfosoft.bts.bean.ProjectPlatformBean;
import arthinfosoft.bts.util.DBConnection1;

public class ProjectPlatformDAO {

	public boolean insertData(ProjectPlatformBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String insertSQL = "insert into bts.Project_Platform(Platform_description) values (?) ";

			try {
				pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, bean.getPlatform_description());
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
			String deleteSQL = "delete from bts.Project_Platform where Platform_id=?";
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

	public List<ProjectPlatformBean> listData() {
		List<ProjectPlatformBean> list = new ArrayList<ProjectPlatformBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectPlatformBean bean = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String listSQL = "select * from bts.Project_Platform";

			try {
				pstmt = conn.prepareStatement(listSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean = new ProjectPlatformBean();
					bean.setPlatform_id(rs.getInt("Platform_id"));
					bean.setPlatform_description(rs
							.getString("Platform_description"));
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

	public ProjectPlatformBean editData(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProjectPlatformBean bean = new ProjectPlatformBean();
		conn = DBConnection1.getConnection();

		if (conn != null) {
			String editSQL = "Select * from bts.Project_Platform where Platform_id=?";
			try {
				pstmt = conn.prepareStatement(editSQL);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					bean.setPlatform_id(rs.getInt("Platform_id"));
					bean.setPlatform_description(rs.getString("Platform_description"));

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

	public boolean updateData(ProjectPlatformBean bean) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection1.getConnection();
		if (conn != null) {
			String updateSQL = "update bts.Project_Platform set Platform_description=? where Platform_id=?";
			try {
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, bean.getPlatform_description());
				pstmt.setInt(2, bean.getPlatform_id());
				int result = pstmt.executeUpdate();
				if (result > 0) {
					flag = true;
				}

			} catch (SQLException e) {
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
