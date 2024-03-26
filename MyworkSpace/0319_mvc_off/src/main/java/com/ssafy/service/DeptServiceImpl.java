package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.DeptDao;
import com.ssafy.dao.DeptDaoImpl;
import com.ssafy.dto.Dept;

public class DeptServiceImpl implements DeptService {
	
	private DeptDao deptDao = new DeptDaoImpl();

	@Override
	public boolean registerDept(Dept dept) throws Exception {
		if (deptDao.selectDept(dept.getDeptno()) == null ) {
			return deptDao.insertDept(dept) > 0;
		}
		return false;
	}

	@Override
	public boolean modifyDept(Dept dept) throws Exception {
		return deptDao.updateDept(dept) > 0;
	}

	@Override
	public boolean removeDept(int deptno) throws Exception {
		return deptDao.deleteDept(deptno) > 0;
	}

	@Override
	public Dept getDept(int deptno) throws Exception {
		return deptDao.selectDept(deptno);
	}

	@Override
	public List<Dept> getDepts() throws Exception {
		return deptDao.selectDepts();
	}

	@Override
	public List<Dept> getDepts(String dname) throws Exception {
		return deptDao.selectDepts(dname);
	}

}