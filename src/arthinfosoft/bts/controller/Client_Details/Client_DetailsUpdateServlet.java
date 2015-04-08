package arthinfosoft.bts.controller.Client_Details;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.Client_DetailsBean;
import arthinfosoft.bts.dao.Client_DetailsDAO;
import arthinfosoft.bts.util.ValidationUtils;


public class Client_DetailsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("client_details_id"));
		String client_details_name = request
				.getParameter("client_details_name");
		String client_details_email = request
				.getParameter("client_details_email");
		
		
		String client_details_password = request
				.getParameter("client_details_password");
		String client_details_securityquestion = request
				.getParameter("client_details_securityquestion");
		String client_details_answer = request
				.getParameter("client_details_answer");
		String client_details_phone_no = request
				.getParameter("client_details_phone_no");
		String client_details_address = request
				.getParameter("client_details_address");
		String client_details_fax = request.getParameter("client_details_fax");
		String client_details_website = request
				.getParameter("client_details_website");

		Client_DetailsBean bean = new Client_DetailsBean();

		bean.setClient_id(id);
		bean.setEmail(client_details_email);
		bean.setClient_name(client_details_name);
		bean.setPassword(client_details_password);
		bean.setSecurityquestion(client_details_securityquestion);
		bean.setAnswer(client_details_answer);
		bean.setPhone_no(client_details_phone_no);
		bean.setAddress(client_details_address);
		bean.setFax(client_details_fax);
		bean.setWebsite(client_details_website);
		
		Boolean isError = false;

		//client_details_name
		if (ValidationUtils.isEmpty(client_details_name)) {
			request.setAttribute("client_details_name",
					"<font color=red>Is Required </font>");
			isError = true;
		}

		if (client_details_name.length() > 20) {
			request.setAttribute("client_details_name",
					"<font color=red>Size Should be less than 20</font>");
			isError = true;
		}
		
		//client_details_email
		if (ValidationUtils.isEmpty(client_details_email)) {
			request.setAttribute("client_details_email",
					"<font color=red>Is Required </font>");
			isError = true;
		}

		if (client_details_email.length() > 40) {
			request.setAttribute("client_details_email",
					"<font color=red>Size Should be less than 40</font>");
			isError = true;
		}
		
		
		//client_details_password
		if (ValidationUtils.isEmpty(client_details_password)) {
			request.setAttribute("client_details_password",
					"<font color=red>Is Required </font>");
			isError = true;
		}

		if (client_details_password.length() > 10) {
			request.setAttribute("client_details_password",
					"<font color=red>Size Should be less than 10</font>");
			isError = true;
		}

		//client_details_securityquestion
		if (ValidationUtils.isEmpty(client_details_securityquestion)) {
			request.setAttribute("client_details_securityquestion",
					"<font color=red>Is Required </font>");
			isError = true;
		}

		if (client_details_securityquestion.length() > 50) {
			request.setAttribute("client_details_securityquestion",
					"<font color=red>Size Should be less than 50</font>");
			isError = true;
		}

		//client_details_answer
		if (ValidationUtils.isEmpty(client_details_answer)) {
			request.setAttribute("client_details_answer",
					"<font color=red>Is Required </font>");
			isError = true;
		}

		if (client_details_answer.length() > 20) {
			request.setAttribute("client_details_answer",
					"<font color=red>Size Should be less than 20</font>");
			isError = true;
		}

		//client_details_phone_no
		if (ValidationUtils.isEmpty(client_details_phone_no)) {
			request.setAttribute("client_details_phone_no",
					"<font color=red>Is Required </font>");
			isError = true;
		}

		if (client_details_phone_no.length() > 20) {
			request.setAttribute("client_details_phone_no",
					"<font color=red>Size Should be less than 15</font>");
			isError = true;
		}

		//Client_Details_Address
		if (ValidationUtils.isEmpty(client_details_address)) {
			request.setAttribute("client_details_address",
					"<font color=red>Is Required </font>");
			isError = true;
		}

		if (client_details_name.length() > 200) {
			request.setAttribute("client_details_address",
					"<font color=red>Size Should be less than 200</font>");
			isError = true;
		}

		//client_details_fax
		if (ValidationUtils.isEmpty(client_details_fax)) {
			request.setAttribute("client_details_fax",
					"<font color=red>Is Required </font>");
			isError = true;
		}

		if (client_details_fax.length() > 20) {
			request.setAttribute("client_details_fax",
					"<font color=red>Size Should be less than 10</font>");
			isError = true;
		}

		//client_details_website
		if (ValidationUtils.isEmpty(client_details_website)) {
			request.setAttribute("client_details_website",
					"<font color=red>Is Required </font>");
			isError = true;
		}

		
	

		if (isError) {
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("Client_DetailsEdit.jsp").forward(
					request, response);
		} else {

		Client_DetailsDAO dao = new Client_DetailsDAO();
		boolean flag = dao.updateData(bean);

		if (flag) {
			response.sendRedirect("Client_DetailsListServlet");
		} else {
			response.sendRedirect("Client_DetailsListServlet");

		}

	}
	}

}