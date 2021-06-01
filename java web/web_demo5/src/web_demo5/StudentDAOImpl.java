package web_demo5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl extends BaseDAO implements StudentDao {
  Connection conn=null;
  PreparedStatement psmt=null;
  ResultSet rs=null;
	@Override
	public boolean addStudent(Student user) {
		String sql="insert into t_zbt value(?,?,?,?,?)";
		if(super.executeUpdate(sql,user.getSid(),user.getSname(),user.getPwd(),user.getGender(),user.getAddress()))
				{
			System.out.println("³É¹¦");
				}
		else System.out.println("Ê§°Ü");
		return	super.executeUpdate(sql,user.getSid(),user.getSname(),user.getPwd(),user.getGender(),user.getAddress());
	}
	@Override
	public List<Student> getStudentList() {
		List<Student> Students=new ArrayList<Student>();
		String sql="select * from t_zbt";
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next())
			{
				String pid=rs.getString(1);
				String pname=rs.getString(2);
				String pwd=rs.getString(3);
				String gender=rs.getString(4);
				String address=rs.getString(5);
				Student stu=new Student (pid,pname,pwd,gender,address);
				Students.add(stu);
			}
			return Students;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			close(rs,psmt,conn);
		}
		return null;
	}

	@Override
	public Student getStudent(String sid, String pwd) {
		String sql="select * from t_zbt where sid= ? and pwd= ? ";
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,sid);
			psmt.setString(2,pwd);
			rs=psmt.executeQuery();
			if(rs.next())
		{
			String sname=rs.getString(2);
			String gender=rs.getString(4);
			String address=rs.getString(5);
			return new Student(sid,sname,pwd,gender,address);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		
		
		
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delStudent(String sid) {
		conn=getConn();
		String sql="delete from t_zbt where sid=?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,sid);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		
		
	}
	@Override
	public boolean isExists(String sid) {
		String sql="select count(*) from t_zbt where sid=?";
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,sid);
			rs=psmt.executeQuery();
			if(rs.next())
			{
				int count=rs.getInt(1);
				return count>0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		
		return false;
	}
	@Override
	public List<Student> getStudentList(String keyword) {
		List<Student> studentList=new ArrayList<Student>();
		String sql="select * from t_zbt where sname like ? or gender like ? or address like ?";
		conn=getConn();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,"%"+keyword+"%");
			psmt.setString(2,"%"+keyword+"%");
			psmt.setString(3,"%"+keyword+"%");
			rs=psmt.executeQuery();
			while(rs.next()){
				String sid=rs.getString(1);
				String sname=rs.getString(2);
				String pwd=rs.getString(3);
				String gender=rs.getString(4);
				String address=rs.getString(5);
				Student student=new Student(sid, sname, pwd, gender, address);
				studentList.add(student);
			}
			return studentList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(rs,psmt,conn);
		}
		return null;
	}
}
	
