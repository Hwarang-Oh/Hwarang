package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Dept;
import com.ssafy.util.DBUtil;

public class DeptDAO {
	
	// 부서 등록
	public int insertDept(Dept dept) throws SQLException {
		Connection conn = null;
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?);";
		PreparedStatement stmt = null;
		int rowCount = 0;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, dept.getDeptno()); // 첫 번째 자리 -> deptno
			stmt.setString(2, dept.getDname());
			stmt.setString(3, dept.getLoc());
			rowCount = stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt, conn);
		}
		return rowCount;
		/*  당장은 여기서 catch 하는게 맞을 것 같지만.
	 	Controller까지 Exception이 가야함 -> 뷰한테 알려줘야 함
	 	try -> finally 쓰려고 작성
		 */
	}
	// 부서 수정
	public int updateDept(Dept dept) throws SQLException {
		Connection conn = null;
		String sql = "update dept set dname = ?, loc = ? where deptno = ?";
		PreparedStatement stmt = null;
		int rowCount = 0;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dept.getDname());
			stmt.setString(2, dept.getLoc());
			stmt.setInt(3, dept.getDeptno());
			rowCount = stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt, conn);
		}
		return rowCount;
	}
	// 부서 삭제
	public int deleteDept(int deptno) throws SQLException {
		Connection conn = null;
		String sql = "delete from dept where deptno = ?";
		PreparedStatement stmt = null;
		int rowCount = 0;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, deptno);
			rowCount = stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt, conn);
		}
		return rowCount;
	}
	// 부서 목록 조회
	// 페이징에서 페이지 개수 제한 -> Array 써도 됨, 그러나 마지막 페이지 고려 心
	public List<Dept> selectDepts() throws SQLException { // 나중에는 많아서 페이징 관련 인자를 추가해야함
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select deptno,dname,loc from dept"; // * 아스타리카 사용 시 컬럼 순서 = 테이블 생성 순서
		PreparedStatement stmt = null;
		List<Dept> list = new ArrayList<Dept>();
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3))); // "deptno" -> 컬럼 명 사용 가능 
			}
		} finally {
			DBUtil.close(stmt, conn, rs);
		}
		
		return list;
	}
	
	public List<Dept> selectDepts(String dname) throws SQLException { // 나중에는 많아서 페이징 관련 인자를 추가해야함
		Connection conn = null;
		ResultSet rs = null;
//		String sql = "select deptno,dname, loc, from dept where dname like cocnat('%',?,'%')"; // * 아스타리카 사용 시 컬럼 순서 = 테이블 생성 순서
		String sql = "select deptno,dname,loc from dept where dname like ?";
		PreparedStatement stmt = null;
		List<Dept> list = new ArrayList<Dept>();
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
//			stmt.setString(1,dname);
			stmt.setString(1,"%" + dname + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3))); // "deptno" -> 컬럼 명 사용 가능 
			}
		} finally {
			DBUtil.close(stmt, conn, rs);
		}
		
		return list;
	}
	
	
	// 부서조회-deptno
	public Dept selectDept(int deptno) throws SQLException {
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select deptno,dname, loc from dept where deptno = ?";
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, deptno);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new Dept(rs.getInt(1), rs.getString("deptno"), rs.getString(3));
			}
		} finally {
			DBUtil.close(rs, stmt, conn);
		}
		
		return null;
	}
}
