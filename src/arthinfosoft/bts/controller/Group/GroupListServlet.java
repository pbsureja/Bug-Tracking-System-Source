package arthinfosoft.bts.controller.Group;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.GroupBean;
import arthinfosoft.bts.dao.GroupDAO;

public class GroupListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<GroupBean> list=new ArrayList<GroupBean>();
		GroupDAO dao=new GroupDAO();
		list=dao.listData();
		if(list!=null){
			request.setAttribute("list", list);
			request.getRequestDispatcher("GroupListPage.jsp").forward(request, response);
		}

		
	}

}
