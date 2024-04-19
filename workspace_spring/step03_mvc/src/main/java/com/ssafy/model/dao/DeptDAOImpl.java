package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ssafy.model.dto.Dept;
import com.ssafy.util.DBUtil;

public class DeptDAOImpl implements DeptDAO {

	private DataSource ds;

	public DeptDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	// 부서등록
	@Override
	public int insertDept(Dept dept) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
		int rowCount = 0;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, dept.getDeptno());
			stmt.setString(2, dept.getDname());
			stmt.setString(3, dept.getLoc());
			rowCount = stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt, conn);
		}
		return rowCount;
	}

	// 부서수정
	@Override
	public int updateDept(Dept dept) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "update dept set dname = ?, loc = ? where deptno = ?";
		int rowCount = 0;
		try {
			conn = ds.getConnection();
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

	// 부서삭제
	@Override
	public int deleteDept(int deptno) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "delete from dept where deptno = ?";
		int rowCount = 0;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, deptno);
			rowCount = stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt, conn);
		}
		return rowCount;
	}

	// 부서목록조회
	@Override
	public List<Dept> selectDepts() throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select deptno,dname,loc from dept";
		List<Dept> list = new ArrayList<Dept>();

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3)));
			}

		} finally {
			DBUtil.close(rs, stmt, conn);
		}
		return list;
	}

	// 부서목록조회 - 부서이름포함검색
	@Override
	public List<Dept> selectDeptsByName(String dname) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// String sql = "select deptno,dname,loc from dept where dname like
		// concat('%',?,'%')";
		String sql = "select deptno,dname,loc from dept where dname like ?";
		List<Dept> list = new ArrayList<Dept>();

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			// stmt.setString(1, dname);
			stmt.setString(1, "%" + dname + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString("dname"), rs.getString(3)));
			}

		} finally {
			DBUtil.close(rs, stmt, conn);
		}
		return list;
	}

	// 부서조회-deptno
	@Override
	public Dept selectDept(int deptno) throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select deptno,dname,loc from dept where deptno = ?";

		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, deptno);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} finally {
			DBUtil.close(rs, stmt, conn);
		}
		return null;
	}
}
