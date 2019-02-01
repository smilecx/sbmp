package com.ziyun.cloud.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebUtils {

	/**
	 * 得到当前线程的HttpServletRequest
	 */
	public static HttpServletRequest getCurrentHttpServletRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		return request;
	}

	/**
	 * 得到HttpServletResponse
	 */
	public static HttpServletResponse getCurrentHttpServletResponse() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletResponse response = requestAttributes.getResponse();
		return response;
	}

	/**
	 * 得到session
	 * 
	 */
	public static HttpSession getCurrentSession() {
		return getCurrentHttpServletRequest().getSession();
	}

	/**
	 * 得到context
	 * 
	 */
	public static ServletContext getServletContext() {
		return getCurrentHttpServletRequest().getServletContext();
	}
	
	
	/**
	 *  得到seesion的对象
	 */ 
	@SuppressWarnings("unchecked")
	public static <T> T getCurrentUser(Class<T> cls,String attributeName){
		return (T) getCurrentSession().getAttribute(attributeName);
	}

}
