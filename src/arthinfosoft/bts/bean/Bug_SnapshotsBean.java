package arthinfosoft.bts.bean;

public class Bug_SnapshotsBean {
	private int snapshot_id;
	private int bug_id;
	private String snapshot_description;
	private Bug_DetailsBean bbean;
	
	public Bug_SnapshotsBean(){
	snapshot_id=0;
	bug_id=0;
	snapshot_description=" ";
	bbean=new Bug_DetailsBean();
	}
	public Bug_DetailsBean getBbean() {
		return bbean;
	}
	public void setBbean(Bug_DetailsBean bbean) {
		this.bbean = bbean;
	}
	public int getSnapshot_id() {
		return snapshot_id;
	}
	public void setSnapshot_id(int snapshot_id) {
		this.snapshot_id = snapshot_id;
	}
	public int getBug_id() {
		return bug_id;
	}
	public void setBug_id(int bug_id) {
		this.bug_id = bug_id;
	}
	public String getSnapshot_description() {
		return snapshot_description;
	}
	public void setSnapshot_description(String snapshot_description) {
		this.snapshot_description = snapshot_description;
	}

	
	
}
