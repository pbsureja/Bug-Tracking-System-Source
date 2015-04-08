package arthinfosoft.bts.controller.Employee_Detail;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.dao.EmployeeDetailDAO;

public class EmployeeDetailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<EmployeeDetailBean> list = new ArrayList<EmployeeDetailBean>();
		EmployeeDetailDAO dao = new EmployeeDetailDAO();
		list = dao.listData();
		if (list != null) {
			request.setAttribute("list", list);
			if(request.getParameter("show")!=null){
			if(request.getParameter("show").equals("show")){
				request.setAttribute("show_id",request.getParameter("tid"));
				request.setAttribute("show","show");
			}}
			
			request.getRequestDispatcher("EmployeeDetailListPage.jsp").forward(
					request, response);

		
		
		}

	}
}
