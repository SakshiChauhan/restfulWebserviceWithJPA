package com.sakshi.rest.webservices.restfulwebservices.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Sakshi Chauhan");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Jayant", "Goyal"));
	}
	
	@GetMapping(value="person/param",params="version=1")
	public PersonV1 paramPersonV1() {
		return new PersonV1("Sakshi Chauhan From Parameter");
	}
	
	@GetMapping(value="person/param",params="version=2")
	public PersonV2 paramPersonV2() {
		return new PersonV2(new Name("Jayant", "Goyal From parameter"));
	}
	
	@GetMapping(value="person/header",headers="X-API-VERSION=1")
	public PersonV1 headerPersonV1() {
		return new PersonV1("Sakshi Chauhan From header");
	}
	
	@GetMapping(value="person/header",headers="X-API-VERSION=2")
	public PersonV2 headerPersonV2() {
		return new PersonV2(new Name("Jayant", "Goyal From header"));
	}
	
	@GetMapping(value="person/produces",produces="application/version1+json")
	public PersonV1 producesPersonV1() {
		return new PersonV1("Sakshi Chauhan From produces");
	}
	
	@GetMapping(value="person/produces",produces="application/version2+json")
	public PersonV2 producesPersonV2() {
		return new PersonV2(new Name("Jayant", "Goyal From produces"));
	}
}
