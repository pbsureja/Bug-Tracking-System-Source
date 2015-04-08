package arthinfosoft.bts.controller.Bug_Priority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugPriorityBean;
import arthinfosoft.bts.dao.BugPriorityDAO;


public class BugPriorityListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<BugPriorityBean> list=new ArrayList<BugPriorityBean>();
	BugPriorityDAO dao=new BugPriorityDAO();
	list=dao.listData();

	if(list!=null){
		request.setAttribute("list",list);
		request.getRequestDispatcher("BugPriorityListPage.jsp").forward(request, response);
	}
	
	}

}
