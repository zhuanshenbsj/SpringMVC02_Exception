package com.wcxu.myException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver2 implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		// 追加异常日志记录
		try {
			FileWriter out = new FileWriter("D:\\error.log", true);
			PrintWriter pw = new PrintWriter(out);
			arg3.printStackTrace(pw);
			pw.flush();
			pw.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 定位到错误页面
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		return mav;
	}

}
