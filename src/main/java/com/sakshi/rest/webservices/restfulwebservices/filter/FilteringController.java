package com.sakshi.rest.webservices.restfulwebservices.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public TestFilterBean getBean() {
		return new TestFilterBean("data1","data2","data3");
	}
	
	@GetMapping("/filtering-list")
	public List<TestFilterBean> getBeanList() {
		return Arrays.asList(new TestFilterBean("data1","data2","data3"),
				new TestFilterBean("data11","data22","data33"),
				new TestFilterBean("data111","data222","data333"));
	}

}
