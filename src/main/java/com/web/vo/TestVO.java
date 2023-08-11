package com.web.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter

public class TestVO {
 private String name;
}

class Exam {
	public static void main(String[] args) {
		TestVO t1= new TestVO();
		t1.setName("홍길동");
		TestVO t2= new TestVO();
		t2.setName("홍길동");
		
		System.out.println(t1.equals(t2));
	}
}
