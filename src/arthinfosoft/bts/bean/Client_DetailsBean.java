package arthinfosoft.bts.bean;

public class Client_DetailsBean {
private int client_id;
private String password;
private String securityquestion;
private String answer;
private String client_name;
private String phone_no;
private String address;
private String fax;
private String website;
private String email;
public Client_DetailsBean() {
 client_id=0;
 password="";
 securityquestion="";
 answer="";
 client_name="";
 phone_no="";
 address="";
 fax="";
 website="";
}



public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
public int getClient_id() {
	return client_id;
}
public void setClient_id(int client_id) {
	this.client_id = client_id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSecurityquestion() {
	return securityquestion;
}
public void setSecurityquestion(String securityquestion) {
	this.securityquestion = securityquestion;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public String getClient_name() {
	return client_name;
}
public void setClient_name(String client_name) {
	this.client_name = client_name;
}
public String getPhone_no() {
	return phone_no;
}
public void setPhone_no(String phone_no) {
	this.phone_no = phone_no;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getFax() {
	return fax;
}
public void setFax(String fax) {
	this.fax = fax;
}
public String getWebsite() {
	return website;
}
public void setWebsite(String website) {
	this.website = website;
}
}
