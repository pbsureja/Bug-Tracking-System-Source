package arthinfosoft.bts.controller.Department;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.DepartmentBean;
import arthinfosoft.bts.dao.DepartmentDAO;

public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<DepartmentBean> list=new ArrayList<DepartmentBean>();
		DepartmentDAO dao=new DepartmentDAO();
		list=dao.listData();
		if(list!=null){
			request.setAttribute("list", list);
			request.getRequestDispatcher("DepartmentListPage.jsp").forward(request, response);
		}

		
	}

}
