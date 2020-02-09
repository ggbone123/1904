package com.thzhima.advance.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.thzhima.advance.bean.Student;

public class Demo {

	
	public void add(String name, String loginName, String passwd) throws SQLException {
		Connection conn = null;
		Statement stm = null;
		try {
			
			// 2�����ӵ����ݿ�
			conn = ConnHelp.getConnection();
			// 3�������ݿⷢ�����
			stm = conn.createStatement();
			String sql = "insert into students(name,loginName,passwd)values('"+name+"','"+loginName+"','"+passwd+"')"; // ���ѧ��
			stm.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
	}
	
	public List<Student> selectAll() throws SQLException {
		List<Student> list = new ArrayList<Student>(); // List�ǽӿڣ�ArrayList��ʵ���ࡣ
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rst = null;
		try {
			conn = ConnHelp.getConnection();
			stm = conn.createStatement();
			String sql = "select * from students";
			rst = stm.executeQuery(sql);// ��ѯ�ķ���
			
			while(rst.next()) {
				int id = rst.getInt("id");
				String name = rst.getString(2);
				String loginName = rst.getString(3);
				String passwd = rst.getString("passwd");
				
				Student s = new Student(id, name, loginName, passwd);
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != rst) {
				rst.close();
			}
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		return list;
	}
	
	/**
	 * ���ݲ���ѧ����ID,ɾ��ѧ����¼
	 * @param id ѧ��ID
	 * @return ɾ���ļ�¼������
	 * @throws SQLException 
	 */
	public int deleteByID(int id) throws SQLException {
		int count = -1;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = ConnHelp.getConnection();
			stm = conn.createStatement();
			String sql= "delete from students where id="+id;
			count = stm.executeUpdate(sql); // ����ɾ���Ķ�ִ��executeUpdate()
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		return count;
	}
	
	public int modifyPWD(int id, String newPWD) throws SQLException {
		int count = -1;
		Connection conn = null;
		Statement stm = null;
		try {
			conn = ConnHelp.getConnection();
			stm = conn.createStatement();
			String sql= "update students set passwd='"+newPWD+"' where id="+id;
			count = stm.executeUpdate(sql); // ����ɾ���Ķ�ִ��executeUpdate()
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(null != stm) {
				stm.close();
			}
			if(null != conn) {
				conn.close();
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws SQLException {
		
		Demo d = new Demo();
//		d.add("��С��", "wxh", "123456");
////		List<Student> list = d.selectAll();
////		System.out.println(list);
//		
//		System.out.println(d.deleteByID(5));
		
		d.modifyPWD(7, "abc");
	}
}
