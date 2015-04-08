package arthinfosoft.bts.controller.Manager_Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ManagerEmployeeBean;
import arthinfosoft.bts.dao.ManagerEmployeeDAO;
public class ManagerEmployeeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("tid"));
		ManagerEmployeeDAO dao = new ManagerEmployeeDAO();
		ManagerEmployeeBean bean = dao.editData(id);
		if (bean != null) {
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("ManagerEmployeeEditPage.jsp").forward(
					request, response);

		} else {
			request.getRequestDispatcher("ManagerEmployeeListServlet");
		}
	}

	}

