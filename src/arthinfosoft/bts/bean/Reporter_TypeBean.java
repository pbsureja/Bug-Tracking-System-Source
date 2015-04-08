package arthinfosoft.bts.bean;

public class Reporter_TypeBean {

	
	private int reporter_type_id;
	private String reporter_type_name;
	
	public Reporter_TypeBean() {
	
		reporter_type_id=0;
		reporter_type_name="";
	}

	public int getReporter_type_id() {
		return reporter_type_id;
	}

	public void setReporter_type_id(int reporter_type_id) {
		this.reporter_type_id = reporter_type_id;
	}

	public String getReporter_type_name() {
		return reporter_type_name;
	}

	public void setReporter_type_name(String reporter_type_name) {
		this.reporter_type_name = reporter_type_name;
	}
	
	
}
