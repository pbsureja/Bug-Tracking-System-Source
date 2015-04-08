package arthinfosoft.bts.bean;

public class Role_EmployeeBean {

	
	private int Role_id;
	private String Role_Description;
	
	public Role_EmployeeBean() {
	
	Role_id=0;
	Role_Description="";
	}
	
	public int getRole_id() {
		return Role_id;
	}
	public void setRole_id(int role_id) {
		Role_id = role_id;
	}
	public String getRole_Description() {
		return Role_Description;
	}
	public void setRoll_Description(String role_Description) {
		Role_Description = role_Description;
	}
}
