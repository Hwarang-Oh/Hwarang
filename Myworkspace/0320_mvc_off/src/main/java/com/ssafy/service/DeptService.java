package com.ssafy.service;

import java.util.List;

import com.ssafy.dto.Dept;

public interface DeptService { // Service는 Dao와 다르게 Yes or Not의 결과 형태가 필요
	// 부서 등록 기능 
	boolean registerDept(Dept dept) throws Exception;
	
	// 부서 수정 기능
	boolean modifyDept(Dept dept) throws Exception;
	
	// 부서 삭제 기능
	boolean removeDept(int deptno) throws Exception;
	
	// 부서 조회 기능 (단일)
	Dept getDept(int deptno) throws Exception;
	
	// 부서 조회 기능 (목록)
	List<Dept> getDepts() throws Exception;
	
	// 부서 조회 기능 ( 목록 by 이름 )
	List<Dept> getDepts(String dname) throws Exception;
}
