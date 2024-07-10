package com.test.service;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService
{
    @Async
    public void performAsyncTask() {
        System.out.println("Start async task - " + Thread.currentThread().getName());
        try{
            Thread.sleep(2000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("End async task - " + Thread.currentThread().getName());
    }

    @Async
    public void performAnotherAsyncTask() {
        System.out.println("Start another async task - " + Thread.currentThread().getName());
        try {
            // 模拟长时间的任务
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End another async task - " + Thread.currentThread().getName());
    }
}