package arthinfosoft.bts.controller.Task;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.dao.TaskDAO;


public class TaskDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int task_id=Integer.parseInt(request.getParameter("task_id"));
		TaskDAO dao=new TaskDAO();
				
				boolean flag=dao.deleteData(task_id);
				if(flag){
					response.sendRedirect("TaskListServlet");
				}
				else{
					request.getRequestDispatcher("TaskListServlet").forward(request, response);
				}
			}
			


	
	}


