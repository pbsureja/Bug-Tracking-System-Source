package arthinfosoft.bts.controller.Pmt_Status;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import arthinfosoft.bts.bean.PmtStatusBean;
import arthinfosoft.bts.dao.PmtStatusDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class PmtStatusUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		String status_description=request.getParameter("pmtstatusdescription");
		
		PmtStatusBean bean=new PmtStatusBean();
		bean.setStatus_id(id);
		bean.setStatus_description(status_description);
		
		boolean isError=false;
		
		if (ValidationUtils.isEmpty(status_description)) {
			request.setAttribute("status_description",
					"<font color=red>*PMT status description should not be null</font>");
			isError = true;
		}

		if(status_description.length()>25){
			request.setAttribute("status_description_length",
					"<font color=red>*PMT status description should not be greater than 25</font>");
			isError = true;
			
		}
			if (isError) {

				request.setAttribute("bean", bean);
				request.getRequestDispatcher("PmtStatusEditPage.jsp").forward(
						request, response);

			}

			else {

		
		PmtStatusDAO dao=new PmtStatusDAO();
		boolean flag=dao.updateData(bean);
		
		if(flag){
			response.sendRedirect("PmtStatusListServlet");
		}
		else{
			response.sendRedirect("PmtStatusListServlet");

		}
	}

}
}