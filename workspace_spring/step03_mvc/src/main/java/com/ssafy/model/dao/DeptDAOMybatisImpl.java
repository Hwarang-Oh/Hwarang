package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Dept;

@Primary
@Repository
public class DeptDAOMybatisImpl implements DeptDAO {
	/**
	 * @param : 0419 : MyBatis
	 *          Connection Pool 설정
	 */
	private SqlSession sqlSession;

	private static final String NS = "com.ssafy.model.dao.DeptDAO.";

	public DeptDAOMybatisImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	// 부서등록
	@Override
	public int insertDept(Dept dept) {
		return sqlSession.insert(NS + "insertDept", dept);
	}

	// 부서수정
	@Override
	public int updateDept(Dept dept) {
		return sqlSession.update(NS + "updateDept", dept);
	}

	// 부서삭제
	@Override
	public int deleteDept(int deptno) throws SQLException {
		return sqlSession.delete(NS + "deleteDept", deptno);

	}

	// 부서목록조회
	@Override
	public List<Dept> selectDepts() {
		return sqlSession.selectList(NS + "selectDepts");
		// lower Bound 설정도 되긴함
	}

	// 부서목록조회 - 부서이름포함검색
	@Override
	public List<Dept> selectDeptsByName(String dname) throws SQLException {
		return sqlSession.selectList(NS + "selectDeptsByName", dname);
	}

	// 부서조회-deptno
	@Override
	public Dept selectDept(int deptno) {
		return sqlSession.selectOne(NS + "selectDept", deptno); // Generic Type이므로 Return 값이 dept!!
	}
}
