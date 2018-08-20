package org.smart4j.chapter3;

import org.smart4j.framework.filter.FilterChain;
import org.smart4j.framework.filter.MyFilter;

public class Filter2 implements MyFilter{

	public void doFilter(FilterChain filterChain) {
		System.out.println("filter2---开始---");
		filterChain.doFilterChain();
		System.out.println("filter2----结束---");
	}

}
