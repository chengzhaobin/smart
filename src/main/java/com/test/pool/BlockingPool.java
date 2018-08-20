package com.test.pool;

import java.util.concurrent.TimeUnit;

public interface BlockingPool<T> extends Pool<T> {
public T get(long time,TimeUnit timeUnit);
}
