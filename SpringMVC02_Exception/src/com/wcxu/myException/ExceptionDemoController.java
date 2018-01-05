package com.wcxu.myException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionDemoController {

	@RequestMapping("/demo.form")
	public String execute() {
		String string = null;
		string.length();
		return "ok";
	}

	// 局部异常处理
	@ExceptionHandler
	public String handlerException(HttpServletRequest request, Exception ex) {
		request.setAttribute("ex", ex);
		return "error2";
	}
}
