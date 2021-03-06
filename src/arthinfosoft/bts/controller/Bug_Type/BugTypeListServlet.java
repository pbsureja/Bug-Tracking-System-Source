package arthinfosoft.bts.controller.Bug_Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.BugTypeBean;
import arthinfosoft.bts.dao.BugTypeDAO;


public class BugTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<BugTypeBean> list=new ArrayList<BugTypeBean>();
	BugTypeDAO dao=new BugTypeDAO();
	list=dao.listData();

	if(list!=null){
		request.setAttribute("list",list);
		request.getRequestDispatcher("BugTypeListPage.jsp").forward(request, response);
	}
	
	}

}
