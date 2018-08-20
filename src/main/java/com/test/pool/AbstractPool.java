package com.test.pool;
/**
 * 
 * @ClassName AbstractPool  
 * @Description 重写释放链接方法 (检查对象是否可用，可用则放回pool,否则进行相应的处理) 
 * @author chengzhb 
 * @date 2018年8月16日  
 * @param <T>  
 */
public abstract class AbstractPool<T> implements Pool<T>{
	public void relase(T t) {
		if(!isValid(t)) {
			handleInValidReturn(t);
		}else {
			returnToPool(t);
		}
	}
	protected abstract boolean isValid(T t);
	
	protected abstract boolean returnToPool(T t);
	
	protected abstract boolean handleInValidReturn(T t);

}
