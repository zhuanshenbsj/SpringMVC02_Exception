package com.wcxu.myException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用Spring自定义异常处理器
 * @author user
 *
 */
@Controller
public class SimpleMappingExceptionController {

	//不异常处理器
	@RequestMapping("/hello.form")
	public String hello() {
		try {
			String s = null;
			s.length();// 空指针异常
			return "Hello";// 返回视图组件的名字
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping("/hello1.form")
	public String hello1() {
		String s = null;
		s.length();// 空指针异常,会跳到指定的custom_error.jsp
		//throw new RuntimeException();//运行时异常，会跳到默认的视图error.jsp
		return "Hello";// 返回视图组件的名字
	}

	//使用自定义异常
	@RequestMapping("/hello2.form")
	public String hello2() throws Exception {
		throw new CustomException("CustomError");
	}
}
