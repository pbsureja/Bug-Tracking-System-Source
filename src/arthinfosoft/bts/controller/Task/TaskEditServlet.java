package arthinfosoft.bts.controller.Task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.TaskBean;
import arthinfosoft.bts.dao.TaskDAO;
public class TaskEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String task_id=request.getParameter("task_id");
		TaskDAO dao=new TaskDAO();
		TaskBean bean=dao.editData(task_id);
		if(bean!=null){
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("TaskEdit.jsp").forward(request, response);
		}
		else{
			
			System.out.println("Bean is null");
			
		}
		
	}
}