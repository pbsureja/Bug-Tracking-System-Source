package arthinfosoft.bts.controller.Pmt_Status;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.PmtStatusBean;
import arthinfosoft.bts.dao.PmtStatusDAO;
import arthinfosoft.bts.util.ValidationUtils;

public class PmtStatusInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String status_description = request.getParameter("status_description");

		boolean isError = false;

		if (ValidationUtils.isEmpty(status_description)) {
			request.setAttribute("status_description ",
					"<font color=red>* project module task status description Is Required</font>");
			isError = true;

		}

		if (isError) {
			request.getRequestDispatcher("PmtStatusInsertPage.jsp").forward(
					request, response);
		} else {

			PmtStatusBean bean = new PmtStatusBean();

			bean.setStatus_description(status_description);

			PmtStatusDAO dao = new PmtStatusDAO();
			boolean insertflag = dao.insertData(bean);

			if (insertflag) {
				request.getRequestDispatcher("PmtStatusListServlet").forward(
						request, response);
			} else {
				response.sendRedirect("PmtStatusInsertPage.jsp");
			}

		}

	}
}