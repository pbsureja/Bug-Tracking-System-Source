package arthinfosoft.bts.bean;

public class BugAssignBean {
private int bugassign_id;
private int bug_id;
private String bug_name;
private int assigned_to;
private String assigned_to_name;
private int assigned_by;
private String assigned_by_name;
public String getBug_name() {
	return bug_name;
}
public void setBug_name(String bug_name) {
	this.bug_name = bug_name;
}
public String getAssigned_to_name() {
	return assigned_to_name;
}
public void setAssigned_to_name(String assigned_to_name) {
	this.assigned_to_name = assigned_to_name;
}
public String getAssigned_by_name() {
	return assigned_by_name;
}
public void setAssigned_by_name(String assigned_by_name) {
	this.assigned_by_name = assigned_by_name;
}
private String assign_date;
private String complete_date;
private String is_completed;
public int getBugassign_id() {
	return bugassign_id;
}
public void setBugassign_id(int bugassign_id) {
	this.bugassign_id = bugassign_id;
}
public int getBug_id() {
	return bug_id;
}
public void setBug_id(int bug_id) {
	this.bug_id = bug_id;
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
