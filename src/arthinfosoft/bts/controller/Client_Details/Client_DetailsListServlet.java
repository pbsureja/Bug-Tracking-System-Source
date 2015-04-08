package arthinfosoft.bts.controller.Client_Details;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Client_DetailsBean;

import arthinfosoft.bts.dao.Client_DetailsDAO;
import arthinfosoft.bts.dao.Reporter_TypeDAO;

public class Client_DetailsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 List<Client_DetailsBean> list = new ArrayList<Client_DetailsBean>();
	       
		 Client_DetailsDAO dao = new Client_DetailsDAO();
	       list = dao.listData();
	       
	       if(list!=null){
	    	   request.setAttribute("list", list);
	    	   request.getRequestDispatcher("Client_DetailsList.jsp").forward(request, response);
	    	   
	       }
	}
	}


