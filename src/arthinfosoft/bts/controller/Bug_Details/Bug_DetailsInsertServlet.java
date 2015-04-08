package arthinfosoft.bts.controller.Bug_Details;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Bug_DetailsBean;
import arthinfosoft.bts.dao.Bug_DetailsDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class Bug_DetailsInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task_id=request.getParameter("task_id");
		String bug_name=request.getParameter("bug_name");
		String bug_status_id=request.getParameter("bug_status_id");
		String reporter_type_id=request.getParameter("reporter_type_id");
		String reported_by=request.getParameter("reported_by");
		String priority_id=request.getParameter("priority_id");
		String reported_date=request.getParameter("reported_date");
		String bug_type_id=request.getParameter("bug_type_id");
		Bug_DetailsBean bean=new Bug_DetailsBean();
		Boolean isError=false;
		
		//bug name
		if(ValidationUtils.isEmpty(bug_name)){
			request.setAttribute("bug_name",
					"<font color=red>Is Required </font>");
			isError = true;
		}else{
			bean.setBug_name(bug_name);
		}
		
		if(bug_name.length()>20){
			request.setAttribute("bug_name_length",
					"<font color=red>Length should be less than 20</font>");
			isError = true;
		}
		
		
		
		//reported date
		if(ValidationUtils.isEmpty(reported_date)){
			request.setAttribute("reported_date",
					"<font color=red>Is Required </font>");
			isError = true;
		}else{
			bean.setReported_date(reported_date);
		}
		
		
//		task_id
		if(task_id.equals("")){
			request.setAttribute("task_id",
					"<font color=red>Is Required</font>");
			isError = true;
		}else{
			bean.setTask_id(Integer.parseInt(task_id));
		}
		

		
//		bug_status_id
		if(bug_status_id.equals("")){
			request.setAttribute("bug_status_id",
					"<font color=red>Is Required </font>");
			isError = true;
		}else{
			bean.setBug_status_id(Integer.parseInt(bug_status_id));
		}
		
		
//		reporter_type_id
		if(reporter_type_id.equals("")){
			request.setAttribute("reporter_type_id",
					"<font color=red>Is Required </font>");
			isError = true;
		}else{
			bean.setReporter_type_id(Integer.parseInt(reporter_type_id));
		}
//		reported_by
		if(reported_by.equals("")){
			request.setAttribute("reported_by",
					"<font color=red>Is Required </font>");
			isError = true;
		}else{
			bean.setReported_by(Integer.parseInt(reported_by));
		}
//		priority_id
		if(priority_id.equals("")){
			request.setAttribute("priority_id",
					"<font color=red>Is Required </font>");
			isError = true;
		}else{
			bean.setBug_Priority_id(Integer.parseInt(priority_id));
		}

//		bug_type_id
		if(bug_type_id.equals("")){
			request.setAttribute("bug_type_id",
					"<font color=red>Is Required </font>");
			isError = true;
		}else{
			bean.setBug_type_id(Integer.parseInt(bug_type_id));
		}
		
		
		
		
		if(isError){
			
	request.setAttribute("bean",bean);		
			request.getRequestDispatcher("Bug_DetailsInsert.jsp").forward(request, response);
			
		}else{
		Boolean flag=new Bug_DetailsDAO().insert(bean);
		if(flag){
			response.sendRedirect("Bug_DetailsListServlet");
			System.out.println("Data Inserted");
		}else{
			response.sendRedirect("Bug_DetailsListServlet");
			System.out.println("Data Not Inserted");
			
			
		}
		
		}

	}

}
