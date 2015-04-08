package arthinfosoft.bts.bean;

public class GroupBean {
	public GroupBean(){
		group_id=0;
		group_description=" ";
		max_limit=0;
		manager_id=0;
		mbean=new ManagerEmployeeBean();
	}
private int group_id;
private String group_description;
private int max_limit;
private int manager_id;
private ManagerEmployeeBean mbean;
private EmployeeDetailBean ebean;
public EmployeeDetailBean getEbean() {
	return ebean;
}
public void setEbean(EmployeeDetailBean ebean) {
	this.ebean = ebean;
}

public ManagerEmployeeBean getMbean() {
	return mbean;
}
public void setMbean(ManagerEmployeeBean mbean) {
	this.mbean = mbean;
}

public int getGroup_id() {
	return group_id;
}
public void setGroup_id(int group_id) {
	this.group_id = group_id;
}
public String getGroup_description() {
	return group_description;
}
public void setGroup_description(String group_description) {
	this.group_description = group_description;
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

}
