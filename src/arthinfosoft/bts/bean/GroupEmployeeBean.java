package arthinfosoft.bts.bean;

public class GroupEmployeeBean {
private int group_id;
private int employee_id;
private EmployeeDetailBean ebean;
private GroupBean gbean;

public GroupEmployeeBean(){
group_id=0;
employee_id=0;
ebean=new EmployeeDetailBean();
gbean=new GroupBean();
}

public GroupBean getGbean() {
	return gbean;
}

public void setGbean(GroupBean gbean) {
	this.gbean = gbean;
}

public int getGroup_id() {
	return group_id;
}
public void setGroup_id(int group_id) {
	this.group_id = group_id;
}
public int getEmployee_id() {
	return employee_id;
}
public EmployeeDetailBean getEbean() {
	return ebean;
}

public void setEbean(EmployeeDetailBean ebean) {
	this.ebean = ebean;
}

public void setEmployee_id(int employee_id) {
	this.employee_id = employee_id;
}

}
