package arthinfosoft.bts.controller.Bug_Assign;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugAssignBean;
import arthinfosoft.bts.dao.BugAssignDAO;
import arthinfosoft.bts.util.ValidationUtils;

//left work validation for isCompleted assign date complete date

public class BugAssignInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String bug_id = request.getParameter("bug_id");
		String assigned_to = request.getParameter("assigned_to");
		String assigned_by = request.getParameter("assigned_by");
		String is_completed = request.getParameter("is_completed");
		String assign_date = request.getParameter("assign_date");
		String complete_date = request.getParameter("complete_date");
		
		System.out.println("complete_date:"+complete_date);
		
	
		
		BugAssignBean bean = new BugAssignBean();
		bean.setBug_id(Integer.parseInt(bug_id));
		bean.setAssigned_to(Integer.parseInt(assigned_to));
		bean.setAssigned_by(Integer.parseInt(assigned_by));
		bean.setIs_completed(is_completed);
		bean.setAssign_date(assign_date);
		bean.setComplete_date(complete_date);

		boolean isError = false;

		if (bug_id.equals("0")) {
			request.setAttribute("bug_id",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}

		
		if (assigned_to.equals("0")) {
			request.setAttribute("assigned_to",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}

		if (assigned_by.equals("0")) {
			request.setAttribute("assigned_by",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}

		
		if (!(is_completed.equals("Y") || is_completed.equals("N"))) {
			request.setAttribute("is_completed",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}
		
		if(ValidationUtils.isEmpty(assign_date)){
			request.setAttribute("assign_date", "<font color=red>* Assign date cannot be null.</font>");
			isError=true;
		}
		


		/*
		if (ValidationUtils.isEmpty(group_description)) {
			request.setAttribute("group_description",
					"<font color=red>* group description cannot be null.</font>");
			isError = true;
		}
*/

		/*
		 * if(max_limit>999){ request.setAttribute("group_description_length",
		 * "<font color=red>* group description cannot be greater than 999</font>"
		 * ); isError=true;
		 * 
		 * }
		 */

		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("BugAssignInsertPage.jsp").forward(
					request, response);
		} else {

			BugAssignDAO dao = new BugAssignDAO();
			boolean flag = dao.insertData(bean);

			if (flag) {
				request.getRequestDispatcher("BugAssignListServlet").forward(
						request, response);

			} else {
				response.sendRedirect("BugAssignInsertPage.jsp");
			}
		}

	}

}
