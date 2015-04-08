package arthinfosoft.bts.controller.Project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ProjectBean;
import arthinfosoft.bts.dao.ProjectDAO;

public class ProjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 List<ProjectBean> list = new ArrayList<ProjectBean>();
	       
		 ProjectDAO dao = new ProjectDAO();
	       list = dao.listData();
	       
	       if(list!=null){
	    	   request.setAttribute("list", list);
	    	   request.getRequestDispatcher("ProjectList.jsp").forward(request, response);
	    	   
	       }
	}	
	}

