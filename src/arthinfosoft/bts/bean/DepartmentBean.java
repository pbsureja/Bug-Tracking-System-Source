package arthinfosoft.bts.bean;

public class DepartmentBean {
	public DepartmentBean(){
		department_id=0;
		department_description=" ";
		max_limit=0;
		manager_id=0;
		setManager_name("");
	}
private int department_id;
private String manager_name;
public int getDepartment_id() {
	return department_id;
}
public void setDepartment_id(int department_id) {
	this.department_id = department_id;
}
public String getDepartment_description() {
	return department_description;
}
public void setDepartment_description(String department_description) {
	this.department_description = department_description;
}
public int getMax_limit() {
	return max_limit;
}
public void setMax_limit(int max_limit) {
	this.max_limit = max_limit;
}
public int getManager_id() {
	return manager_id;
}
public void setManager_id(int manager_id) {
	this.manager_id = manager_id;
}
public String getManager_name() {
	return manager_name;
}
public void setManager_name(String manager_name) {
	this.manager_name = manager_name;
}
private String department_description;
private int max_limit;
private int manager_id;

}

