package arthinfosoft.bts.controller.Bug_Assign;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugAssignBean;
import arthinfosoft.bts.dao.BugAssignDAO;

public class BugAssignListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<BugAssignBean> list = new ArrayList<BugAssignBean>();
		BugAssignDAO dao = new BugAssignDAO();
		list = dao.listData();
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("BugAssignListPage.jsp").forward(
					request, response);

		}

	}
}