package arthinfosoft.bts.controller.Manager_Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ManagerEmployeeBean;
import arthinfosoft.bts.dao.ManagerEmployeeDAO;
public class ManagerEmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		List<ManagerEmployeeBean> list=new ArrayList<ManagerEmployeeBean>();
		ManagerEmployeeDAO dao=new ManagerEmployeeDAO();
		list=dao.listData();
		if(list!=null){
			request.setAttribute("list", list);
			request.getRequestDispatcher("ManagerEmployeeListPage.jsp").forward(request, response);
		}



	}

}
