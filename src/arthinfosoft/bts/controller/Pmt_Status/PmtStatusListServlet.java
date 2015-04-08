package arthinfosoft.bts.controller.Pmt_Status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.PmtStatusBean;
import arthinfosoft.bts.dao.PmtStatusDAO;


public class PmtStatusListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<PmtStatusBean> list=new ArrayList<PmtStatusBean>();
	PmtStatusDAO dao=new PmtStatusDAO();
	list=dao.listData();

	if(list!=null){
		request.setAttribute("list",list);
		request.getRequestDispatcher("PmtStatusListPage.jsp").forward(request, response);
	}
	
	}

}
