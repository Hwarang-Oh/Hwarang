package com.ssafy.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.Dept;

public interface DeptDao { // DAO Interface
	// 부서 등록
	int insertDept(Dept dept) throws SQLException;
	
	// 부서 수정
	int updateDept(Dept dept) throws SQLException;
	
	// 부서 삭제
	int deleteDept(int deptno) throws SQLException;
	
	// 부서 조회 (단일)
	Dept selectDept(int deptno) throws SQLException;
	
	// 부서 조회 (목록)
	List<Dept> selectDepts() throws SQLException;
	
	// 부서 조회 (이름)
	List<Dept> selectDepts(String dname) throws SQLException;
}
