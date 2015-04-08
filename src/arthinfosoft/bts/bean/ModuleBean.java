package arthinfosoft.bts.bean;

public class ModuleBean {

	private int module_id;
	private String project_name;
	private String code;
	private String description;
	private int status_id;
	private int project_id;
	private String estimated_start_date;
	private String estimated_end_date;
	private String actual_start_date;
	private String actual_end_date;
	private int modified_by;
	private String modified_date;
	
	private PmtStatusBean bsbean;
	private ProjectBean pbean;
	
	
	private EmployeeDetailBean ebean;
	
	public ModuleBean(){
		module_id=0; 
		project_id=0;
		 project_name="";
		 code="";
		 description="";
		 status_id=0;
		 estimated_start_date="";
		 estimated_end_date="";
		 actual_start_date="";
		 actual_end_date="";
		 modified_by=0;
		modified_date="";
		bsbean=new PmtStatusBean();
		pbean=new ProjectBean();
		ebean=new EmployeeDetailBean();
		
	}
	
	
	public PmtStatusBean getBsbean() {
		return bsbean;
	}


	public void setBsbean(PmtStatusBean bsbean) {
		this.bsbean = bsbean;
	}


	public ProjectBean getPbean() {
		return pbean;
	}


	public void setPbean(ProjectBean pbean) {
		this.pbean = pbean;
	}

	public EmployeeDetailBean getEbean() {
		return ebean;
	}


	public void setEbean(EmployeeDetailBean ebean) {
		this.ebean = ebean;
	}


	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public String getEstimated_start_date() {
		return estimated_start_date;
	}
	public void setEstimated_start_date(String estimated_start_date) {
		this.estimated_start_date = estimated_start_date;
	}
	public String getEstimated_end_date() {
		return estimated_end_date;
	}
	public void setEstimated_end_date(String estimated_end_date) {
		this.estimated_end_date = estimated_end_date;
	}
	public String getActual_start_date() {
		return actual_start_date;
	}
	public void setActual_start_date(String actual_start_date) {
		this.actual_start_date = actual_start_date;
	}
	public String getActual_end_date() {
		return actual_end_date;
	}
	public void setActual_end_date(String actual_end_date) {
		this.actual_end_date = actual_end_date;
	}
	public int getModified_by() {
		return modified_by;
	}
	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
	}
	public String getModified_date() {
		return modified_date;
	}
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	
	
}
