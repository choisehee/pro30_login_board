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
			System.out.println("��Ƽ������ ���� �����"+viewName);
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
		System.out.println("getRequestURI()�� ���� ������ uri"+uri);
		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		System.out.println("ó�� ���ؽ� ��ġ (���ؽ��� �н� ����):"+begin);
		int end;
		System.out.println(";�� ��ġ ������ -1"+uri.indexOf(";"));
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}
		System.out.println("uri ���� ������ ���ؽ� ��ġ"+end);

		String fileName = uri.substring(begin, end);
		System.out.println("���� �����"+fileName);
		
		System.out.println("����� . �� ������ -1 �ִٸ� ����ġ : "+fileName.indexOf("."));
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
			System.out.println("������ �� ������ �ִ� �κи� �����´�"+fileName);
		}
		System.out.println("������� /�� ������ -1 �ִٸ� �� ��ġ"+fileName.lastIndexOf("/"));
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/", 1), fileName.length());
			System.out.println(fileName);
			
		}
		return fileName;
	}
}
