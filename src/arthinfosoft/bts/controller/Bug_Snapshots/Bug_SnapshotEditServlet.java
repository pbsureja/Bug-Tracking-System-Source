package arthinfosoft.bts.controller.Bug_Snapshots;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Bug_SnapshotsBean;
import arthinfosoft.bts.dao.Bug_SnapshotsDAO;


public class Bug_SnapshotEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("tid"));
		Bug_SnapshotsDAO dao=new Bug_SnapshotsDAO();
		Bug_SnapshotsBean bean=dao.editData(id);
		if(bean!=null){
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("Bug_SnapshotEdit.jsp").forward(request, response);
		}
		else{
			System.out.println("Bean is null");
		}
		
	}

}
