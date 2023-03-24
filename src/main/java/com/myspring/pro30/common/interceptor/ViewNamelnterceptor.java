package com.myspring.pro30.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNamelnterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			String viewName = getViewName(request);
			request.setAttribute("viewName", viewName);
			System.out.println("인티셉에서 찍은 뷰네임"+viewName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		System.out.println("getRequestURI()를 통해 가져온 uri"+uri);
		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		System.out.println("처음 인텍스 위치 (컨텍스프 패스 길이):"+begin);
		int end;
		System.out.println(";의 위치 없으면 -1"+uri.indexOf(";"));
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}
		System.out.println("uri 길이 마지막 인텍스 위치"+end);

		String fileName = uri.substring(begin, end);
		System.out.println("최종 뷰네임"+fileName);
		
		System.out.println("뷰네임 . 이 없으면 -1 있다면 그위치 : "+fileName.indexOf("."));
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			System.out.println("마지막 점 앞으로 있는 부분만 가져온다"+fileName);
		}
		System.out.println("뷰네임이 /가 없으면 -1 있다면 그 위치"+fileName.lastIndexOf("/"));
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/", 1), fileName.length());
			System.out.println(fileName);
			
		}
		return fileName;
	}
}
