package arthinfosoft.bts.controller.Task_Assign;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.TaskAssignBean;
import arthinfosoft.bts.dao.TaskAssignDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class TaskAssignUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int task_assign_id = Integer.parseInt(request.getParameter("id"));
		String task_id = request.getParameter("task_id");
		String assigned_to = request.getParameter("assigned_to");
		String assigned_by = request.getParameter("assigned_by");
		String is_completed = request.getParameter("is_completed");
		String assign_date = request.getParameter("assign_date");
		String complete_date = request.getParameter("complete_date");

		TaskAssignBean bean = new TaskAssignBean();
		bean.setTaskassign_id(task_assign_id);
		bean.setTask_id(Integer.parseInt(task_id));			
		bean.setAssigned_to(Integer.parseInt(assigned_to));
		bean.setAssigned_by(Integer.parseInt(assigned_by));
		bean.setIs_completed(is_completed);
		bean.setComplete_date(complete_date);
		bean.setAssign_date(assign_date);
		
		boolean isError = false;

		// validation
		if (request.getParameter("task_id").equals("0")) {
			request.setAttribute("task_id",
					"<font color=red>*Is Required</font>");
			isError = true;

		}

		if (request.getParameter("assigned_to").equals("0")) {
			request.setAttribute("assigned_to",
					"<font color=red>*Is Required</font>");
			isError = true;

		}

		if (request.getParameter("assigned_by").equals("0")) {
			request.setAttribute("assigned_by",
					"<font color=red>*Is Required</font>");
			isError = true;

		}


		if(ValidationUtils.isEmpty(assign_date)){
			request.setAttribute("assign_date", "<font color=red>*Is Required</font>");
			isError=true;
		}
		

		
		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("TaskAssignEditPage.jsp").forward(request,
					response);

		} else {
			TaskAssignDAO dao = new TaskAssignDAO();
			boolean flag = dao.updateData(bean);

			if (flag) {
				response.sendRedirect("TaskAssignListServlet");
			} else {
				response.sendRedirect("TaskAssignListServlet");

			}
		}

	}

}
