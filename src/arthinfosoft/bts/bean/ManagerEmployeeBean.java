package arthinfosoft.bts.bean;

public class ManagerEmployeeBean {
private int manager_id;
private int employee_id;
private EmployeeDetailBean ebean;
public ManagerEmployeeBean(){
manager_id=0;
employee_id=0;
ebean=new EmployeeDetailBean();
}

public EmployeeDetailBean getEbean() {
	return ebean;
}

public void setEbean(EmployeeDetailBean ebean) {
	this.ebean = ebean;
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

}
