package arthinfosoft.bts.controller.Bug_Snapshots;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Bug_SnapshotsBean;
import arthinfosoft.bts.bean.Reporter_TypeBean;
import arthinfosoft.bts.dao.Bug_SnapshotsDAO;
import arthinfosoft.bts.dao.Reporter_TypeDAO;


public class Bug_SnapshotsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 List<Bug_SnapshotsBean> list = new ArrayList<Bug_SnapshotsBean>();
	       
		 Bug_SnapshotsDAO dao = new Bug_SnapshotsDAO();
	       list = dao.listData();
	       
	       if(list!=null){
	    	   request.setAttribute("list", list);
	    	   request.getRequestDispatcher("Bug_SnapshotsList.jsp").forward(request, response);
	    	   
	       }
	}	
		
	}


