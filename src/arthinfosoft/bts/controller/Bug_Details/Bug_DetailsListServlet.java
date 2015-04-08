package arthinfosoft.bts.controller.Bug_Details;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import arthinfosoft.bts.bean.Bug_DetailsBean;
import arthinfosoft.bts.dao.Bug_DetailsDAO;

public class Bug_DetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 List<Bug_DetailsBean> list = new ArrayList<Bug_DetailsBean>();
	       
		 Bug_DetailsDAO dao = new Bug_DetailsDAO();
	       list = dao.listData();
	       
	       if(list!=null){
	    	   request.setAttribute("list", list);
	    	   request.getRequestDispatcher("Bug_DetailsList.jsp").forward(request, response);
	    	   
	       }
	}	

	}


