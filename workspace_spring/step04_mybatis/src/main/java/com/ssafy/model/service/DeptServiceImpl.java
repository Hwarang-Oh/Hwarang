package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dto.Dept;

@Service
public class DeptServiceImpl implements DeptService {

	private DeptDAO deptDao;

	public DeptServiceImpl(DeptDAO deptDao) {
		super();
		this.deptDao = deptDao;
	}

	@Override
	public boolean registerDept(Dept dept) throws Exception {
		// dept내용으로 Dept 테이블에 저장
		if (deptDao.selectDept(dept.getDeptno()) == null) {
			return deptDao.insertDept(dept) > 0;
		}
		return false;
	}

	@Override
	public boolean modifyDept(Dept dept) throws Exception {
		return deptDao.updateDept(dept) > 0;
	}

	@Override
	public boolean removeDept(int[] deptno) throws Exception {
		return deptDao.deleteDept(deptno) > 0;
	}

	@Override
	public List<Dept> getDepts() throws Exception {
		return deptDao.selectDepts();
	}

	@Override
	public List<Dept> getDepts(String dname) throws Exception {
		return deptDao.selectDeptsByDname(dname);
	}

	@Override
	public Dept getDept(int deptno) throws Exception {
		return deptDao.selectDept(deptno);
	}

	@Override
	public List<Dept> getDeptsByMultiCondition(Map<String, Object> contition) throws Exception {
		return deptDao.selectDeptsByMultiCondition(contition);
	}

}
