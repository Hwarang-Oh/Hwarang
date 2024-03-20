package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dao.DeptDAOImpl;
import com.ssafy.model.dto.Dept;

public class DeptServiceImpl implements DeptService {
	// 왜 매개변수를 유효성 체크를 하지 않을까?? DeptService까지 온다는 것은 어느정도 유효성 검사가  완료된 상황을 가정하는것!!

	private DeptDAO deptDao = new DeptDAOImpl();
	
	@Override
	public boolean registerDept(Dept dept) throws Exception {
		// TODO Dept내용으로 Dept Table에 저장
		if (deptDao.selectDept(dept.getDeptno()) == null) {
			return deptDao.insertDept(dept) > 0;
		}
		return false;
	}

	@Override
	public boolean modifyDept(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		return deptDao.updateDept(dept) > 0;
	}

	@Override
	public boolean removeDept(int deptno) throws Exception {
		// TODO Auto-generated method stub
		return deptDao.deleteDept(deptno) > 0;
	}

	@Override
	public List<Dept> getDepts() throws Exception {
		// TODO Auto-generated method stub
		return deptDao.selectDepts(); // 페이징 기법 (몇개를 보여달라 ~ -> Controller의 계산역할? DAO의 계산역할? => controller? )
	}

	@Override
	public List<Dept> getDepts(String dname) throws Exception {
		// TODO Auto-generated method stub
		return deptDao.selectDepts(dname);
	}

	@Override
	public Dept getDept(int deptno) throws Exception {
		// TODO Auto-generated method stub
		return deptDao.selectDept(deptno);
	}
}
