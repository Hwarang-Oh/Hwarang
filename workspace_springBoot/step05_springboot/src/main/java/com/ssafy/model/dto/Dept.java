package com.ssafy.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Dept {
	@NonNull
	private int deptno;
	@NonNull
	private String dname;
	@NonNull
	private String loc;
	private List<Emp> emps; // Emp 별도로 만들어 줘야 한다. 1 : N의 관계s
}
