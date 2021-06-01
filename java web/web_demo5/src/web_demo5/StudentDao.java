package web_demo5;
import java.util.List;
public interface StudentDao {
       Student getStudent(String sid,String pwd);
       List<Student> getStudentList();
       void delStudent(String sid);
       boolean addStudent(Student student);
       boolean isExists(String sid);
       List<Student> getStudentList(String keyword);
}
