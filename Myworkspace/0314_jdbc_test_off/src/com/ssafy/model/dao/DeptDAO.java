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
		PreparedStatement pstmt = null;
		int rCnt = 0;
		String sql = "Insert into dept(deptno, dname, loc) Values (?,?,?)";
		try {
			int cIdx = 1;
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(cIdx++, dept.getDeptno());
			pstmt.setString(cIdx++, dept.getDname());
			pstmt.setString(cIdx++, dept.getLoc());
			rCnt = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return rCnt;
	}
	// 부서 수정
	public int updateDept(Dept dept) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Update dept set dname = ?, loc = ?  where deptno = ?";
		int rCnt = 0;
		try {
			int cIdx = 1;
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(cIdx++, dept.getDname());
			pstmt.setString(cIdx++, dept.getLoc());
			pstmt.setInt(cIdx++, dept.getDeptno());
			rCnt = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return rCnt; 
	}
	// 부서 삭제
	public int deleteDept(int deptno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Delete from dept where deptno = ?";
		int rCnt = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,deptno);
			rCnt = pstmt.executeUpdate();
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return rCnt;
	}
	// 부서 목록 조회
	// 페이징에서 페이지 개수 제한 -> Array 써도 됨, 그러나 마지막 페이지 고려
	// 나중에는 많아서 페이징 관련 인자를 추가해야함
	public List<Dept> selectDepts() throws SQLException { 
		// Select문 => Result Set이 필요한 Case!
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select deptno, dname, loc from dept";
		List<Dept> list = new ArrayList<Dept>();
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3)));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	// 나중에는 많아서 페이징 관련 인자를 추가해야함
	// 부서 목록 조회 - by 부서이름!
	public List<Dept> selectDepts(String dname) throws SQLException { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select deptno, dname, loc from dept where dname like ?";
		List <Dept> list = new ArrayList<Dept>();
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + dname + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	
	
	// 부서조회-deptno
	public Dept selectDept(int deptno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select deptno, dname, loc from dept where deptno = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return null;
	}
}
