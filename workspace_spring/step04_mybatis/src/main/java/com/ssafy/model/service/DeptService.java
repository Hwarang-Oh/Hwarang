package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.model.dto.Dept;

public interface DeptService {

	// 부서등록
	boolean registerDept(Dept dept) throws Exception;

	// 부서수정
	boolean modifyDept(Dept dept) throws Exception;

	// 부서삭제
	boolean removeDept(int deptno) throws Exception;

	// 부서목록조회
	List<Dept> getDepts() throws Exception;

	// 부서목록조회 - 부서이름포함검색
	List<Dept> getDepts(String dname) throws Exception;

	// 부서조회-deptno
	Dept getDept(int deptno) throws Exception;

	// 부서조회 - 다양조건
	List<Dept> getDeptsByMultiContition(Map<String, Object> contition) throws Exception;
}
