package arthinfosoft.bts.controller.Group;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.GroupBean;
import arthinfosoft.bts.dao.GroupDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class GroupUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int group_id = Integer.parseInt(request.getParameter("id"));
		String group_description = request.getParameter("group_description");
		String max_limit = request.getParameter("max_limit");
		String manager_id = request.getParameter("manager_id");

		GroupBean bean = new GroupBean();
		bean.setGroup_id(group_id);
		bean.setGroup_description(group_description);
		bean.setManager_id(Integer.parseInt(manager_id));
		bean.setMax_limit(0);

		boolean isError = false;

		// validation
		if (request.getParameter("manager_id").equals("0")) {
			request.setAttribute("manager_id",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}

		if (ValidationUtils.isEmpty(group_description)) {
			request.setAttribute("group_description_empty",
					"<font color=red>* group description cannot be null.</font>");
			isError = true;
		}

		if (group_description.length() > 20) {
			request.setAttribute(
					"group_description_length",
					"<font color=red>* group description cannot be greater than 20 characters.</font>");
			isError = true;

		}

		if (ValidationUtils.isEmpty(request.getParameter("max_limit"))) {
			request.setAttribute("max_limit_empty",
					"<font color=red>* Max limit cannot be null. </font>");
			isError = true;
		}

		String numToken = "[\\p{Digit}&&[0123456789]]+";
		if (max_limit.matches(numToken)) {
			if (max_limit.length() <= 3) {
				if (Integer.parseInt(max_limit) > 999) {
					request.setAttribute("max_limit_length",
							"<font color=red>* Max limit cannot be greater than 999.</font>");
					isError = true;

				} else if (Integer.parseInt(max_limit) < 999)
					bean.setMax_limit(Integer.parseInt(max_limit));
			} else {
				request.setAttribute("max_limit_length",
						"<font color=red>* Max limit cannot be greater than 999.</font>");
				isError = true;

			}
		} else {
			request.setAttribute("max_limit_empty",
					"<font color=red>* Max limit should be numbers only.</font>");
			isError = true;

		}

		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("GroupEditPage.jsp").forward(request,
					response);

		} else {
			GroupDAO dao = new GroupDAO();
			boolean flag = dao.updateData(bean);

			if (flag) {
				response.sendRedirect("GroupListServlet");
			} else {
				response.sendRedirect("GroupListServlet");

			}
		}

	}
}
