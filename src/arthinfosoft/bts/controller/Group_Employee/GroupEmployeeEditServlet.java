package arthinfosoft.bts.controller.Group_Employee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.GroupEmployeeBean;
import arthinfosoft.bts.dao.GroupEmployeeDAO;
public class GroupEmployeeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("tid"));
		GroupEmployeeDAO dao = new GroupEmployeeDAO();
		GroupEmployeeBean bean = dao.editData(id);
		if (bean != null) {
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("GroupEmployeeEditPage.jsp").forward(
					request, response);

		} else {
			request.getRequestDispatcher("GroupEmployeeListServlet");
		}
	}

	}

