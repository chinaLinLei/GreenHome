package com.greenhome.service.inter.thread;

import java.util.concurrent.ExecutionException;

/**
 * @Author smart_joker
 * @Date 2022/6/22 3:56 下午
 * @Description 多线程异步使用（接口）
 * @Version 1.0
 */
public interface ThreadBaseService {
     String doTest() throws ExecutionException, InterruptedException;
}
