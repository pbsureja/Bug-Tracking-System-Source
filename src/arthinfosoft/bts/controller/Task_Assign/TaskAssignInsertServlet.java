package arthinfosoft.bts.controller.Task_Assign;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.TaskAssignBean;
import arthinfosoft.bts.dao.TaskAssignDAO;
import arthinfosoft.bts.util.ValidationUtils;

//left work validation for isCompleted assign date complete date

public class TaskAssignInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String task_id = request.getParameter("task_id");
		String assigned_to = request.getParameter("assigned_to");
		String assigned_by = request.getParameter("assigned_by");
		String is_completed = request.getParameter("is_completed");
		String assign_date = request.getParameter("assign_date");
		String complete_date = request.getParameter("complete_date");

		
		TaskAssignBean bean = new TaskAssignBean();
		bean.setTask_id(Integer.parseInt(task_id));
		bean.setAssigned_to(Integer.parseInt(assigned_to));
		bean.setAssigned_by(Integer.parseInt(assigned_by));
		bean.setIs_completed(is_completed);
		bean.setAssign_date(assign_date);
		bean.setComplete_date(complete_date);

		boolean isError = false;

		if (task_id.equals("0")) {
			request.setAttribute("task_id",
					"<font color=red>* Is Required</font>");
			isError = true;

		}

		
		if (assigned_to.equals("0")) {
			request.setAttribute("assigned_to",
					"<font color=red>* Is Required</font>");
			isError = true;

		}

		if (assigned_by.equals("0")) {
			request.setAttribute("assigned_by",
					"<font color=red>* Is Required</font>");
			isError = true;

		}

		
		if (!(is_completed.equals("Y") || is_completed.equals("N"))) {
			request.setAttribute("is_completed",
					"<font color=red>* Is Required</font>");
			isError = true;

		}
		
		if(ValidationUtils.isEmpty(assign_date)){
			request.setAttribute("assign_date", "<font color=red>*Is Required</font>");
			isError=true;
		}
		




		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("TaskAssignInsertPage.jsp").forward(
					request, response);
		} else {

			TaskAssignDAO dao = new TaskAssignDAO();
			boolean flag = dao.insertData(bean);

			if (flag) {
				request.getRequestDispatcher("TaskAssignListServlet").forward(
						request, response);

			} else {
				response.sendRedirect("TaskAssignInsertPage.jsp");
			}
		}

	}

}
