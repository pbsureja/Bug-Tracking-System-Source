package arthinfosoft.bts.controller.Project_Platform;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.ProjectPlatformBean;
import arthinfosoft.bts.dao.ProjectPlatformDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class ProjectPlatformUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String Platform_description = request.getParameter("projectplatformdescription");
		
		ProjectPlatformBean bean = new ProjectPlatformBean();
		bean.setPlatform_id(id);
		bean.setPlatform_description(Platform_description);

		boolean isError=false;
		
		if (ValidationUtils.isEmpty(Platform_description)) {
			request.setAttribute("Platform_description",
					"<font color=red>*Is Required</font>");
			isError = true;
		}
		if(Platform_description.length()>25){
			request.setAttribute("Platform_description_length",
					"<font color=red>*Platform description should not be greater than 25</font>");
			isError = true;
			
		}

		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("ProjectPlatformEditPage.jsp").forward(
					request, response);

		}

		else {

		
		ProjectPlatformDAO dao = new ProjectPlatformDAO();
		boolean flag = dao.updateData(bean);
		if (flag) {
			response.sendRedirect("ProjectPlatformListServlet");
		} else {

			response.sendRedirect("ProjectPlatformListServlet");
			
		}
	}
	}
}
