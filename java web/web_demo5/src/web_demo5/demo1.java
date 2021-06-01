package web_demo5;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class demo1 {
	StudentDAOImpl test=new StudentDAOImpl();
	List<Student> stus=new ArrayList<Student>();
@Test
public void add(){
	Student stu=new Student("20","zbt","123456","nan","fujian");
	test.addStudent(stu);
}
@Test
public void delete(){
	test.delStudent("20");
	
}
@Test
public void getlist(){
	stus=test.getStudentList();
	for (int i = 0; i <stus.size(); i++) {
		System.out.println(stus.get(i));
	}
}
@Test
public void getlist2(){
	stus=test.getStudentList("fujian");
	for (int i = 0; i <stus.size(); i++) {
		System.out.println(stus.get(i));
	}
}
}


