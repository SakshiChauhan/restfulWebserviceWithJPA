package com.sakshi.rest.webservices.restfulwebservices.helloWord;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET, path = "/hello-word")
	public String getHelloWord() {
		return "Hello Word";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hello-word-bean")
	public HelloWordBean getHelloWordBean() {
		return new HelloWordBean("Hello Sakshi from bean");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hello-word-bean/{name}")
	public HelloWordBean getHelloWordBeanPath(@PathVariable String name) {
		return new HelloWordBean("Hello Sakshi from bean " + name);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/say-hi")
	public String sayHiInternationalization(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/say-hi-no-header")
	public String sayHiInternationalizationWithoutParameter() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
