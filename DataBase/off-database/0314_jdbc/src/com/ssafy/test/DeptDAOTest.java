package com.ssafy.test;

import java.sql.SQLException;

import com.ssafy.model.dao.DeptDAO;
import com.ssafy.model.dto.Dept;

public class DeptDAOTest {
	public static void main(String[] args) throws SQLException {
		
		System.out.println("부서목록조회");
		DeptDAO dao = new DeptDAO();
		dao.deleteDept(50);
		dao.deleteDept(60);
		dao.insertDept(new Dept(50, "개발1팀", "서울"));
		dao.insertDept(new Dept(60, "혁신개발2팀", "서울"));
		
		for (Dept dept : dao.selectDepts()) {
			System.out.println(dept);
		}
		

		System.out.println("부서조회");
		Dept dept = dao.selectDept(50);
		System.out.println(dept);
		dept.setDname("혁신개발1팀");
		dept.setLoc("제주");
		dao.updateDept(dept);
		
		
		System.out.println("부서수정");
		System.out.println("부서목록이름포함조회");
		for(Dept d : dao.selectDepts("개발")) {
			System.out.println(d);
		}
		
		System.out.println("부서삭제조회");
		dao.deleteDept(60);
		System.out.println(dao.selectDept(60));
		
	}

}
