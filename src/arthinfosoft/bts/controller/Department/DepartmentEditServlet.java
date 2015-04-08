package arthinfosoft.bts.controller.Department;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.DepartmentBean;
import arthinfosoft.bts.dao.DepartmentDAO;

public class DepartmentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("tid"));
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentBean bean = dao.editData(id);
		if (bean != null) {
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("DepartmentEditPage.jsp").forward(
					request, response);

		} else {
			request.getRequestDispatcher("DepartmentListServlet");
		}
	}

	}

