package org.smart4j.chapter3;

import org.smart4j.framework.annotation.Intercept;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.interceptor.MyInterceptor;
@Intercept(url="/test")
public class InterceptTest implements MyInterceptor{

	public void preHandler(Param parm) {
		System.out.println("开始拦截1===========");
	}

	public void postHandler() {
		System.out.println("结束拦截1===========");
	}

}
