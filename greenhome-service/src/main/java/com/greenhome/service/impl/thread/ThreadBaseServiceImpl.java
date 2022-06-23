package com.greenhome.service.impl.thread;

import com.greenhome.service.inter.thread.ThreadBaseService;
import org.springframework.stereotype.Service;
import java.util.concurrent.*;

/**
 * @Author smart_joker
 * @Date 2022/6/22 4:03 下午
 * @Description 多线程异步使用（实现类）
 * @Version 1.0
 */
@Service
public class ThreadBaseServiceImpl implements ThreadBaseService {
    @Override
    public String doTest() throws ExecutionException, InterruptedException {
        //创建一个线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                20,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(50),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<String> futureImg = CompletableFuture.supplyAsync(() -> {
            return "hello.jpg";
        }, threadPoolExecutor);

        CompletableFuture<String> futureAttr = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "黑色+256G";
        }, threadPoolExecutor);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "人民币：¥555.555";
        }, threadPoolExecutor);

        CompletableFuture<String> futureDesc = CompletableFuture.supplyAsync(() -> {
            return "华为";
        }, threadPoolExecutor);
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futureImg, futureAttr, futureDesc,future2);
        allOf.join();//等待所有结果完成
        return "main....end..." + futureImg.get() + "=>" + futureAttr.get() + "=>" + futureDesc.get()+ "=>" + future2.get();
    }

}
