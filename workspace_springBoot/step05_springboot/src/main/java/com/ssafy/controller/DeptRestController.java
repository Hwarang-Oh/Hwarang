package com.ssafy.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.Dept;
import com.ssafy.model.service.DeptService;

// /dept 로 시작하는 모든 요청들은 로그인해야만 사용할수 있도록 인터셉터 처리하자!!
// 인터셉터에서는 로그인여부 체크해서 로그인 되었으면 계속해서 진행
//								 안되어있으면 로그인화면으로...

@RequestMapping("/api/depts")
@RestController
public class DeptRestController {
    private final DeptService deptService;

    public DeptRestController(DeptService deptService) {
        super();
        this.deptService = deptService;
    }

    // get / api / depts
    // get / api / depts?dname = xxx
    // get / api / depts?loc= yyy
    // get / api / detps?dname=xxx&loc=yyy

    @GetMapping
    protected ResponseEntity<List<Dept>> deptRestList(@RequestParam Map<String, Object> condition) throws Exception {
        return new ResponseEntity<List<Dept>>(deptService.getDeptsByMultiCondition(condition), HttpStatus.OK);
    }
    // Return Type을 List<Dept>로만 하면, 단점이 많음.
    // ResponseEntity<T>를 return값으로 설정해서 주면 된다.
    // ResponseEntity -> 많은 Overloading 존재 -> Builder Pattern

    // @RequestBody로 받아내고 있음
    // 요청 Header도 전송 -> Builder로 구현
    @PostMapping
    protected ResponseEntity<?> registerDept(@RequestBody Dept dept)
            throws Exception {
        boolean result = deptService.registerDept(dept);
        if (result) {
            return ResponseEntity.created(URI.create("/api/depts" + dept.getDeptno())).build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    // PathVariable 설계
    @GetMapping("/{deptno}")
    public ResponseEntity<?> getDeptDetail(@PathVariable("deptno") int deptno)
            throws Exception {
        Dept dept = deptService.getDept(deptno);
        if (dept != null) {
            return ResponseEntity.ok(dept);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Post 대신 PutMapping으로 해보자!!
    @PutMapping("/{deptno}")
    public ResponseEntity<?> modifyDept(@RequestBody Dept dept) throws Exception {
        deptService.modifyDept(dept);
        return ResponseEntity.ok().build();
    }

    // 자원마다 자원에 해당하는 URL이 따로 있음. -> 그렇기에 한번에 삭제하는 기능이 있는 Method는 어울리지 않음.

    @DeleteMapping("/{deptno}")
    public ResponseEntity<?> removeDept(@PathVariable("deptno") int deptno)
            throws Exception {
        if (deptService.removeDept(new int[] { deptno })) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.internalServerError().body(e.getMessage());
    }

    // Rest는 기존의 Global Exception Advice를 타면 안됨 => 다른 Exception Handler를 만들어 줘야 한다.
}
