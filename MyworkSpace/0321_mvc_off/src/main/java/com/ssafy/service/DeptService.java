package com.ssafy.service;

import java.util.List;

import com.ssafy.dto.Dept;

public interface DeptService {
	
	// 부서 등록
	boolean registerDept(Dept dept) throws Exception;
	
	// 부서 수정
	boolean modifyDept(Dept dept) throws Exception;
	
	// 부서 삭제
	boolean removeDept(int deptno) throws Exception;
	
	// 부서 조회 (단일)
	Dept getDept(int deptno) throws Exception;
	
	// 부서 조회 (목록)
	List<Dept> getDepts() throws Exception;
	
	// 부서 조회 (목록 - by 이름)
	List<Dept> getDepts(String dname) throws Exception;
}
