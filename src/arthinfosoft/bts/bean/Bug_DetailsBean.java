package arthinfosoft.bts.bean;

public class Bug_DetailsBean {

	private int bug_id;
	private int task_id;
	private String task;
	private String bug_name;
	private int bug_status_id;
	private String bug_status;
	private int reporter_type_id;
	private String reporter_type_name;
	private int reported_by;
	private String reporter;
	private int bug_priority_id;
	private String priority;
	private String reported_date;
	private int bug_type_id;
	private String bug_type_name;
	public Bug_DetailsBean(){
		bug_id=0;
		task_id=0;
		task="";
		bug_name="";
		bug_status_id=0;
		reporter_type_id=0;
		reported_by=0;
		bug_priority_id=0;
		reported_date="";
		bug_type_id=0;
		bug_status="";
		reporter_type_name="";
		reporter="";
		priority="";
		bug_type_name="";
	}
	
	public String getBug_status() {
		return bug_status;
	}

	public void setBug_status(String bug_status) {
		this.bug_status = bug_status;
	}

	public String getReporter_type_name() {
		return reporter_type_name;
	}

	public void setReporter_type_name(String reporter_type_name) {
		this.reporter_type_name = reporter_type_name;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public int getBug_priority_id() {
		return bug_priority_id;
	}

	public void setBug_priority_id(int bug_priority_id) {
		this.bug_priority_id = bug_priority_id;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getBug_type_name() {
		return bug_type_name;
	}

	public void setBug_type_name(String bug_type_name) {
		this.bug_type_name = bug_type_name;
	}

	public int getBug_id() {
		return bug_id;
	}
	public void setBug_id(int bug_id) {
		this.bug_id = bug_id;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getBug_name() {
		return bug_name;
	}
	public void setBug_name(String bug_name) {
		this.bug_name = bug_name;
	}
	public int getBug_status_id() {
		return bug_status_id;
	}
	public void setBug_status_id(int bug_status_id) {
		this.bug_status_id = bug_status_id;
	}
	public int getReporter_type_id() {
		return reporter_type_id;
	}
	public void setReporter_type_id(int reporter_type_id) {
		this.reporter_type_id = reporter_type_id;
	}
	public int getReported_by() {
		return reported_by;
	}
	public void setReported_by(int reported_by) {
		this.reported_by = reported_by;
	}
	public int getBug_Priority_id() {
		return bug_priority_id;
	}
	public void setBug_Priority_id(int priority_id) {
		this.bug_priority_id = priority_id;
	}
	public String getReported_date() {
		return reported_date;
	}
	public void setReported_date(String reported_date) {
		this.reported_date = reported_date;
	}
	public int getBug_type_id() {
		return bug_type_id;
	}
	public void setBug_type_id(int bug_type_id) {
		this.bug_type_id = bug_type_id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}


}
