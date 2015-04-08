package arthinfosoft.bts.controller.Group;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.GroupBean;
import arthinfosoft.bts.dao.GroupDAO;

public class GroupEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("tid"));
		GroupDAO dao = new GroupDAO();
		GroupBean bean = dao.editData(id);
		if (bean != null) {
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("GroupEditPage.jsp").forward(
					request, response);

		} else {
			request.getRequestDispatcher("GroupListServlet");
		}
	}

	}

