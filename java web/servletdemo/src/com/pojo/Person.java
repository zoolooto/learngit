package com.pojo;

public class Person {
int pid;
String name;
String pwd;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
@Override
public String toString() {
	return "Person [pid=" + pid + ", name=" + name + ", pwd=" + pwd + "]";
}
public Person() {
	super();
	// TODO Auto-generated constructor stub
}
public Person(int pid, String name, String pwd) {
	super();
	this.pid = pid;
	this.name = name;
	this.pwd = pwd;
}

}
