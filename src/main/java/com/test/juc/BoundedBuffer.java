package com.test.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
final Lock lock=new ReentrantLock();

final Condition put=lock.newCondition();

final Condition take=lock.newCondition();

final Object[] items = new Object[5];
int putptr, takeptr, count;

public void put(Object x) throws InterruptedException {
	lock.lock(); //获取锁
	try {
		 // 如果“缓冲已满”，则等待；直到“缓冲”不是满的，才将x添加到缓冲中。
		while(count==items.length) 
			put.await();
		items[putptr]=x;
		 // 将“put统计数putptr+1”；如果“缓冲已满”，则设putptr为0。
        if (++putptr == items.length) putptr = 0;
        // 将“缓冲”数量+1
        ++count;
        // 唤醒take线程，因为take线程通过notEmpty.await()等待
        take.signal();
        // 打印写入的数据
        System.out.println(Thread.currentThread().getName() + " put  "+ (Integer)x);
	}finally {
        lock.unlock();    // 释放锁
    }
}

public Object take() throws InterruptedException {
	lock.lock(); //获取锁
	try {
		while(count==0)
			take.await();
		Object obj=items[takeptr];
		if (++takeptr == items.length) takeptr = 0;
		--count;
		put.signal();
		  // 打印取出的数据
        System.out.println(Thread.currentThread().getName() + " take "+ (Integer)obj);
        return obj;
	}
	finally {
		  lock.unlock();    // 释放锁
	}
}


}
