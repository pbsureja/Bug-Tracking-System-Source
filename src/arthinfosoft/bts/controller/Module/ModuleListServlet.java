package arthinfosoft.bts.controller.Module;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ModuleBean;
import arthinfosoft.bts.dao.ModuleDAO;

public class ModuleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 List<ModuleBean> list = new ArrayList<ModuleBean>();
	       
		 ModuleDAO dao = new ModuleDAO();
	       list = dao.listData();
	       
	       if(list!=null){
	    	   request.setAttribute("list", list);
	    	   request.getRequestDispatcher("ModuleList.jsp").forward(request, response);
	    	   
	       }   
	       
	}	
	}

