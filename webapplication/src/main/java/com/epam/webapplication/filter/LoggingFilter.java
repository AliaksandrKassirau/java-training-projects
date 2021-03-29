package com.epam.webapplication.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingFilter implements Filter {

	private String path;

	public void init(FilterConfig filterConfig) throws ServletException {
		path = filterConfig.getInitParameter("path");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		log.info("Filter is invoked for path:" + path);

		chain.doFilter(request, response);

	}

}
