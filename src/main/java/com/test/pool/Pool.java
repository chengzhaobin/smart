package com.test.pool;

public interface Pool<T>{
	/**
	 * 
	 * @Title: get 
	 * @Description: 返回一个对象
	 * @return 参数说明
	 * @return T    返回类型
	 */
T get();

void relase(T t);

void shutdown();

interface Validator<T>{
	public boolean isValid(T t);
	
	public void invalidate(T t);
}
}
