package com.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    // 秒 分  时   日   月   周
    @Scheduled(cron = "0 13 15 * * ?")
    public void hello(){
        System.out.println("执行中...");
    }
}
