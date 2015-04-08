package arthinfosoft.bts.controller.Bug_Status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugStatusBean;
import arthinfosoft.bts.dao.BugStatusDAO;


public class BugStatusListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<BugStatusBean> list=new ArrayList<BugStatusBean>();
	BugStatusDAO dao=new BugStatusDAO();
	list=dao.listData();

	if(list!=null){
		request.setAttribute("list",list);
		request.getRequestDispatcher("BugStatusListPage.jsp").forward(request, response);
	}
	
	}

}
