package org.smart4j.chapter3;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.proxy.AspectProxy;

/**
 * 
 * @ClassName ControllerAspect  
 * @Description 拦截controller 所有方法 
 * @author chengzhb 
 * @date 2018年8月13日  
 *   
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy{
	private static final Logger LOGGER=LoggerFactory.getLogger(ControllerAspect.class);
	private long begin;
	@Override
	public void before(Class<?> cls, Method method, Object[] params) {
		System.out.println("=================开始==============");
		System.out.println("===========================类:"+cls.getName());
		System.out.println("===========================方法:"+method.getName());
		begin=System.currentTimeMillis();
	}
	@Override
	public void after(Class<?> cls, Method method, Object[] params) {
		System.out.println("花费时间："+(System.currentTimeMillis()-begin));
	}
}
