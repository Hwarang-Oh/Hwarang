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

	// 부서등록
	public int insertDept(Dept dept) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept(deptno, dname, loc) values (?, ?, ?)";
		int rCnt = 0;
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
		} return rCnt;
	} 
	// 부서수정
	public int updateDept(Dept dept) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update dept set dname = ?, loc = ? where deptno = ?";
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
		} return rCnt;
	}

	// 부서삭제
	public int deleteDept(int deptno) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from dept where deptno = ?";
		int rCnt = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rCnt = pstmt.executeUpdate(); // 왜 sql을 Argument에 X?
		} finally {
			DBUtil.close(pstmt, conn);
		} return rCnt;
	}
		
	// 부서목록조회
	public List<Dept> selectDepts() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select deptno, dname, loc from dept";
		List<Dept> list = new ArrayList<Dept>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		} return list;
	}

	// 부서목록조회 - 부서이름포함검색
	public List<Dept> selectDepts(String dname) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select deptno, dname, loc from dept where dname like ?";
		List<Dept> list = new ArrayList<Dept>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + dname + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
		List<Dept> list = new ArrayList<Dept>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		} return null;
	}
}