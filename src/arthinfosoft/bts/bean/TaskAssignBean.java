package arthinfosoft.bts.bean;

public class TaskAssignBean {
private int taskassign_id;
private int task_id;
private int assigned_to;
private int assigned_by;
private String assign_date;
private String complete_date;
private String is_completed;
private TaskBean tbean;
private EmployeeDetailBean ebean;
private EmployeeDetailBean ebean2;
public TaskAssignBean(){
taskassign_id=0;
	task_id=0;
	assigned_to=0;
	assigned_by=0;
	assign_date="";
	complete_date="";
	is_completed="Y";
	tbean=new TaskBean();
	ebean=new EmployeeDetailBean();
	ebean2=new EmployeeDetailBean();
}


public TaskBean getTbean() {
	return tbean;
}


public void setTbean(TaskBean tbean) {
	this.tbean = tbean;
}


public EmployeeDetailBean getEbean() {
	return ebean;
}


public void setEbean(EmployeeDetailBean ebean) {
	this.ebean = ebean;
}



public EmployeeDetailBean getEbean2() {
	return ebean2;
}


public void setEbean2(EmployeeDetailBean ebean2) {
	this.ebean2 = ebean2;
}



public int getTaskassign_id() {
	return taskassign_id;
}
public void setTaskassign_id(int taskassign_id) {
	this.taskassign_id = taskassign_id;
}
public int getTask_id() {
	return task_id;
}
public void setTask_id(int task_id) {
	this.task_id = task_id;
}
public int getAssigned_to() {
	return assigned_to;
}
public void setAssigned_to(int assigned_to) {
	this.assigned_to = assigned_to;
}
public int getAssigned_by() {
	return assigned_by;
}
public void setAssigned_by(int assigned_by) {
	this.assigned_by = assigned_by;
}
public String getAssign_date() {
	return assign_date;
}
public void setAssign_date(String assign_date) {
	this.assign_date = assign_date;
}
public String getComplete_date() {
	return complete_date;
}
public void setComplete_date(String complete_date) {
	this.complete_date = complete_date;
}
public String getIs_completed() {
	return is_completed;
}
public void setIs_completed(String is_completed) {
	this.is_completed = is_completed;
}


}
