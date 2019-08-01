package com.sakshi.rest.webservices.restfulwebservices.helloWord;

public class HelloWordBean {

	private String messageHello;

	public HelloWordBean(String string) {
		this.messageHello = string;
	}

	public String getMessage() {
		return messageHello;
	}

	public void setMessage(String message) {
		this.messageHello = message;
	}

}
