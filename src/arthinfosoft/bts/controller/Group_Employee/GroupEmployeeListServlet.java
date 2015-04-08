package arthinfosoft.bts.controller.Group_Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.GroupEmployeeBean;
import arthinfosoft.bts.dao.GroupEmployeeDAO;
public class GroupEmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		List<GroupEmployeeBean> list=new ArrayList<GroupEmployeeBean>();
		GroupEmployeeDAO dao=new GroupEmployeeDAO();
		list=dao.listData();
		if(list!=null){
			request.setAttribute("list", list);
			request.getRequestDispatcher("GroupEmployeeListPage.jsp").forward(request, response);
		}



	}

}
