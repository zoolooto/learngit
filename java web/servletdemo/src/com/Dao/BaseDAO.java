package com.Dao;
import java.sql.*;
import com.DB.*;
public class BaseDAO {
	protected Connection getConn(){
		try {
			Class.forName(DBInfo.DRIVER);
			return DriverManager.getConnection(DBInfo.URL,DBInfo.USER,DBInfo.PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	protected void close(ResultSet rs,Statement pstm,Connection conn)
	{
		try {
				if(rs!=null)
				{
					rs.close();
				}
				if(pstm!=null)
				{
					pstm.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//÷¥––∏¥∫œsql”Ôæ‰
	public boolean executeUpdate(String sql,Object... params){
		Connection conn=null;
		PreparedStatement pstm=null;
		try {
			conn=getConn();
			pstm=conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++)
			{
				pstm.setObject(i+1,params[i]);
			}
			int count=pstm.executeUpdate();
			return count>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			close(null,pstm,conn);
		}
		return false;
	}
}


