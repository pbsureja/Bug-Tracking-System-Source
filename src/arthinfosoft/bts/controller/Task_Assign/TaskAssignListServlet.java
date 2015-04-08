package arthinfosoft.bts.controller.Task_Assign;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.TaskAssignBean;
import arthinfosoft.bts.dao.TaskAssignDAO;

public class TaskAssignListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<TaskAssignBean> list = new ArrayList<TaskAssignBean>();
		TaskAssignDAO dao = new TaskAssignDAO();
		list = dao.listData();
		if (list != null) {
			request.setAttribute("list", list);
			request.getRequestDispatcher("TaskAssignListPage.jsp").forward(
					request, response);

		}

	}
}