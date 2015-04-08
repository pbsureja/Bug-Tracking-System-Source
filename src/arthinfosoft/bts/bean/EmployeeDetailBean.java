package arthinfosoft.bts.bean;

public class EmployeeDetailBean {

	private int employee_id;
	private String email;
	private String password;	
	private String security_question;
	private String answer;
	private String employee_firstname;
	private String employee_lastname;
	private String permanent_address;
	private String temporary_address;
	private String mobile;
	private String landline;
	private String dateofbirth;
	private int designation;
	private String joining_date;
	private String is_active;
	private int role_id;
	private String role_name;
	private int department_id;
	private String department_name;
	private int manager_id;
	private String manager_name;
	private int salary;
	public EmployeeDetailBean(){
		employee_id=0;
		email="";
		password="";	
		security_question="";
		answer="";
		employee_firstname="";
		employee_lastname="";
		permanent_address="";
		temporary_address="";
		mobile="";
		landline="";
		dateofbirth="";
		designation=0;
		joining_date="";
		is_active="";
		role_id=0;
		department_id=0;
		manager_id=0;
		salary=0;
	}
	
	
	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	public String getDepartment_name() {
		return department_name;
	}


	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}


	public String getManager_name() {
		return manager_name;
	}


	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}


	public int getDepartment_id() {
		return department_id;
	}




	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}


	public int getManager_id() {
		return manager_id;
	}


	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurity_question() {
		return security_question;
	}
	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getEmployee_firstname() {
		return employee_firstname;
	}
	public void setEmployee_firstname(String employee_firstname) {
		this.employee_firstname = employee_firstname;
	}
	public String getEmployee_lastname() {
		return employee_lastname;
	}
	public void setEmployee_lastname(String employee_lastname) {
		this.employee_lastname = employee_lastname;
	}
	public String getPermanent_address() {
		return permanent_address;
	}
	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}
	public String getTemporary_address() {
		return temporary_address;
	}
	public void setTemporary_address(String temporary_address) {
		this.temporary_address = temporary_address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public int getDesignation() {
		return designation;
	}
	public void setDesignation(int designation) {
		this.designation = designation;
	}
	public String getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}
	public String getIs_active() {
		return is_active;
	}
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public int getdepartment_id() {
		return department_id;
	}
	public void setdepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
