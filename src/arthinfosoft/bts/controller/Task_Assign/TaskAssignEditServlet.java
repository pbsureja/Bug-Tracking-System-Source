package arthinfosoft.bts.controller.Task_Assign;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.TaskAssignBean;
import arthinfosoft.bts.dao.TaskAssignDAO;
public class TaskAssignEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("tid"));
		TaskAssignDAO dao = new TaskAssignDAO();
		TaskAssignBean bean = dao.editData(id);
		if (bean != null) {
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("TaskAssignEditPage.jsp").forward(
					request, response);

		} else {
			request.getRequestDispatcher("TaskAssignListServlet");
		}


	}

}
