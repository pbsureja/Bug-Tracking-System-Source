package arthinfosoft.bts.controller.Employee_Detail;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import arthinfosoft.bts.bean.EmployeeDetailBean;
import arthinfosoft.bts.dao.EmployeeDetailDAO;
import arthinfosoft.bts.util.ValidationUtils;
public class EmployeeDetailUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int employee_id = Integer.parseInt(request.getParameter("id"));

		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String security_question=request.getParameter("security_question");
		String answer=request.getParameter("answer");
		String employee_firstname=request.getParameter("employee_firstname");
		String employee_lastname=request.getParameter("employee_lastname");
		String permanent_address=request.getParameter("permanent_address");
		String temporary_address=request.getParameter("temporary_address");
		String mobile=request.getParameter("mobile");
		String landline=request.getParameter("landline");
		String dateofbirth=request.getParameter("dateofbirth");
		String designation=request.getParameter("designation");
		String joining_date=request.getParameter("joining_date");;
		String is_active=request.getParameter("is_active");
		String role_id=request.getParameter("role_id");
		String department_id=request.getParameter("department_id");;
		String manager_id=request.getParameter("manager_id");
		String salary=request.getParameter("salary");

		
		EmployeeDetailBean bean = new EmployeeDetailBean();
		
		bean.setEmployee_id(employee_id);
		bean.setEmail(email);
		bean.setPassword(password);
		bean.setSecurity_question(security_question);
		bean.setAnswer(answer);
		bean.setEmployee_firstname(employee_firstname);
		bean.setEmployee_lastname(employee_lastname);
		bean.setPermanent_address(permanent_address);
		bean.setTemporary_address(temporary_address);
		bean.setMobile(mobile);
		bean.setLandline(landline);
		bean.setDateofbirth(dateofbirth);
		bean.setDesignation(Integer.parseInt(designation));
		bean.setJoining_date(joining_date);
		bean.setIs_active(is_active);
		bean.setRole_id(Integer.parseInt(role_id));
		bean.setdepartment_id(Integer.parseInt(department_id));
		bean.setManager_id(Integer.parseInt(manager_id));

		
		boolean isError = false;

		// validation

		//drop down validation
		if (role_id.equals("0")) {
			request.setAttribute("role_id",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}

		if (department_id.equals("0")) {
			request.setAttribute("department_id",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}		if (manager_id.equals("0")) {
			request.setAttribute("manager_id",
					"<font color=red>* you must select atleast one value.</font>");
			isError = true;

		}
		
		//empty validation
		if (ValidationUtils.isEmpty(email)) {
			request.setAttribute("email",
					"<font color=red>* cannot be empty.</font>");
			isError = true;
		}

		if (email.length() > 30) {
			request.setAttribute(
					"email_length",
					"<font color=red>*cannot be greater than 30 characters.</font>");
			isError = true;

		}

		String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
		Pattern p = Pattern.compile(regEx);
		java.util.regex.Matcher m = p.matcher(email);

		if (!m.find()) {
			request.setAttribute("email_match",
					"<font color=red>*It is not valid email.</font>");
			isError = true;
			
		}

		//password
		if (ValidationUtils.isEmpty(password)) {
			request.setAttribute("password",
					"<font color=red>* cannot be empty.</font>");
			isError = true;
		}

		if (password.length() > 20) {
			request.setAttribute(
					"password_length",
					"<font color=red>*cannot be greater than 20 characters.</font>");
			isError = true;

		}

//security_question
		if (ValidationUtils.isEmpty(security_question)) {
			request.setAttribute("security_question",
					"<font color=red>* cannot be empty.</font>");
			isError = true;
		}

		if (security_question.length() > 50) {
			request.setAttribute(
					"security_question_length",
					"<font color=red>*cannot be greater than 50 characters.</font>");
			isError = true;

		}

		//answer
				if (ValidationUtils.isEmpty(answer)) {
					request.setAttribute("answer",
							"<font color=red>* cannot be empty.</font>");
					isError = true;
				}

				if (answer.length() > 20) {
					request.setAttribute(
							"answer_length",
							"<font color=red>*cannot be greater than 20 characters.</font>");
					isError = true;

				}
				//employee_firstname
				if (ValidationUtils.isEmpty(employee_firstname)) {
					request.setAttribute("employee_firstname",
							"<font color=red>* cannot be empty.</font>");
					isError = true;
				}

				if (employee_firstname.length() > 20) {
					request.setAttribute(
							"employee_firstname_length",
							"<font color=red>*cannot be greater than 20 characters.</font>");
					isError = true;

				}
				//employee_lastname
				if (ValidationUtils.isEmpty(employee_lastname)) {
					request.setAttribute("employee_lastname",
							"<font color=red>* cannot be empty.</font>");
					isError = true;
				}

				if (employee_lastname.length() > 20) {
					request.setAttribute(
							"employee_lastname_length",
							"<font color=red>*cannot be greater than 20 characters.</font>");
					isError = true;

				}
				//permanent_address
				if (ValidationUtils.isEmpty(permanent_address)) {
					request.setAttribute("permanent_address",
							"<font color=red>* cannot be empty.</font>");
					isError = true;
				}

				if (permanent_address.length() > 100) {
					request.setAttribute(
							"permanent_address_length",
							"<font color=red>*cannot be greater than 100 characters.</font>");
					isError = true;

				}
				//temporary_address
				if (ValidationUtils.isEmpty(temporary_address)) {
					request.setAttribute("temporary_address",
							"<font color=red>* cannot be empty.</font>");
					isError = true;
				}

				if (temporary_address.length() > 100) {
					request.setAttribute(
							"temporary_address_length",
							"<font color=red>*cannot be greater than 100 characters.</font>");
					isError = true;

				}
				//mobile
				if (ValidationUtils.isEmpty(mobile)) {
					request.setAttribute("mobile",
							"<font color=red>* cannot be empty.</font>");
					isError = true;
				}

				if (mobile.length() > 14) {
					request.setAttribute(
							"mobile_length",
							"<font color=red>*cannot be greater than 14 characters.</font>");
					isError = true;

				}

				String numToken1 = "[\\p{Digit}&&[0123456789]]+";
				if (!mobile.matches(numToken1)) {
						request.setAttribute("mobile_matches",
								"<font color=red>* mobile can be only numeric values.</font>");
						isError = true;	
				} 
				if (!landline.matches(numToken1)) {
					request.setAttribute("landline_matches",
							"<font color=red>* landline can be only numeric values.</font>");
					isError = true;	
			} 
				//landline
				if (ValidationUtils.isEmpty(landline)) {
					request.setAttribute("landline",
							"<font color=red>* cannot be empty.</font>");
					isError = true;
				}

				if (landline.length() > 13) {
					request.setAttribute(
							"landline_length",
							"<font color=red>*cannot be greater than 13 characters.</font>");
					isError = true;

				}		
		
		
		
		
		if (ValidationUtils.isEmpty(salary)) {
			request.setAttribute("salary",
					"<font color=red>* Salary cannot be null. </font>");
			isError = true;
		}

		String numToken = "[\\p{Digit}&&[0123456789]]+";
		if (salary.matches(numToken)) {
			if (Integer.parseInt(salary) > 999999999) {
				request.setAttribute("salary_length",
						"<font color=red>* salary cannot be greater than 10^10.</font>");
				isError = true;	

			} else {
				bean.setSalary(Integer.parseInt(salary));
			}
		} else {
			request.setAttribute("salary_limit",
					"<font color=red>* Salary should be numbers only.</font>");
			isError = true;

		}

		if (isError) {

			request.setAttribute("bean", bean);
			request.getRequestDispatcher("EmployeeDetailEditPage.jsp").forward(request,
					response);

		} else {
			bean.setSalary(Integer.parseInt(salary));

			EmployeeDetailDAO dao = new EmployeeDetailDAO();
			boolean flag = dao.updateData(bean);

			if (flag) {
				response.sendRedirect("EmployeeDetailListServlet");
			} else {
				response.sendRedirect("EmployeeDetailListServlet");

			}
		}

	}

}
