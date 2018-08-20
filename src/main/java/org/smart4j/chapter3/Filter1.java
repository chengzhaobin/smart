package org.smart4j.chapter3;

import org.smart4j.framework.filter.FilterChain;
import org.smart4j.framework.filter.MyFilter;

public class Filter1 implements MyFilter{

	public void doFilter(FilterChain filterChain) {
		System.out.println("filter1---开始---");
		filterChain.doFilterChain();
		System.out.println("filter1----结束---");
	}

}
