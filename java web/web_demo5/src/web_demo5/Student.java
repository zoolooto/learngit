package web_demo5;

public class Student {
@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", pwd=" + pwd
				+ ", gender=" + gender + ", address=" + address + "]";
	}
private String sid;
private String sname;
private String pwd;
private String gender;
private String address;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(String sid, String sname, String pwd, String gender,
		String address) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.pwd = pwd;
	this.gender = gender;
	this.address = address;
}
public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
