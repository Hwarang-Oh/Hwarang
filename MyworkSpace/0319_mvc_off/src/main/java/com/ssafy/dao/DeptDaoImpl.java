package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.Dept;
import com.ssafy.util.DBUtil;

public class DeptDaoImpl implements DeptDao {

	@Override
	public int insertDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Insert into dept (deptno, dname, loc) values (?,?,?)";
		int rCnt = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2,  dept.getDname());
			pstmt.setString(3, dept.getLoc());
			rCnt = pstmt.executeUpdate(); // pstmt의 Query에 의해 몇개 Update?
		} finally {
			DBUtil.close(pstmt, conn); // close는 반대 순서로 진행한다.
		} return rCnt; 
	}

	@Override
	public int updateDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Update dept set dname = ?, loc = ? where deptno = ?";
		int rCnt = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2,  dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			rCnt = pstmt.executeUpdate(); // pstmt의 Query에 의해 몇개 Update?
		} finally {
			DBUtil.close(pstmt, conn); // close는 반대 순서로 진행한다.
		} return rCnt; 
	}

	@Override
	public int deleteDept(int deptno) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "Delete from dept where deptno = ?";
		int rCnt = 0;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rCnt = pstmt.executeUpdate(); // pstmt의 Query에 의해 몇개 Update?
		} finally {
			DBUtil.close(pstmt, conn); // close는 반대 순서로 진행한다.
		} return rCnt; 
	}

	@Override
	public Dept selectDept(int deptno) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select * from dept where deptno = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery(); // pstmt의 Query에 의한 결과는 어떻게 되는가?
			if (rs.next()) {
				return new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn); // close는 반대 순서로 진행한다.
		} return null;
	}
	@Override
	public List<Dept> selectDepts() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select * from dept";
		List<Dept> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // pstmt의 Query에 의한 결과는 어떻게 되는가?
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn); // close는 반대 순서로 진행한다.
		} return list;
	}

	@Override
	public List<Dept> selectDepts(String dname) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "Select * from dept where dname = ?";
		List<Dept> list = new ArrayList<>();
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + dname + "%");
			rs = pstmt.executeQuery(); // pstmt의 Query에 의한 결과는 어떻게 되는가?
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} finally {
			DBUtil.close(rs, pstmt, conn); // close는 반대 순서로 진행한다.
		} return list;
	}

}
