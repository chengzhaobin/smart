package com.test.pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class BoundedBlockingPool<T> extends AbstractPool<T> implements BlockingPool<T>{
private int size;
private BlockingQueue<T> objects;

private Validator<T> validator;

private ObjectFactory<T> objectFactory;
 
private ExecutorService excutor=Executors.newCachedThreadPool();

private volatile boolean shutdownCalled;


	public BoundedBlockingPool(int size, Validator<T> validator, ObjectFactory<T> objectFactory) {
	super();
	this.size = size;
	this.validator = validator;
	this.objectFactory = objectFactory;
	objects=new LinkedBlockingQueue<T>(size);
	initializeObjects();
	shutdownCalled=false;
}

	private void initializeObjects() {
		for(int i=0;i<size;i++) {
			objects.add(objectFactory.createNew());
		}
	}

	public void shutdown() {
		shutdownCalled=true;
		excutor.shutdown();
		clearResources();
	}

	private void clearResources() {
		for(T t:objects) {
			validator.invalidate(t);
		}
	}

	public T get() {
		if(!shutdownCalled) {
			T t=null;
			try {
				t=objects.take();
				return t;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return t;
		}
		throw new IllegalStateException("Object pool already shutdown");
	}

	public T get(long time, TimeUnit timeUnit){
		if(!shutdownCalled) {
			T t=null;
			try {
				t=objects.poll(time, timeUnit);
				return t;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			return t;
		}
		throw new IllegalStateException("Object pool already shutdown");
	}

	@Override
	protected boolean isValid(T t) {
		return validator.isValid(t);
	}

	@Override
	protected boolean returnToPool(T t) {
		if(validator.isValid(t)) {
			excutor.submit(new ObjectReturner(objects,t));
		}
		return false;
	}

	@Override
	protected boolean handleInValidReturn(T t) {
		return false;
	}
private class ObjectReturner implements Callable{

	private BlockingQueue<T> queue;
	private T t;
	
	public ObjectReturner(BlockingQueue<T> queue,T t) {
		this.queue=queue;
		this.t=t;
	}
	public Void call() throws Exception {
		while(true) {
			queue.put(t);
			break;
		}
		return null;
	}
}
}
