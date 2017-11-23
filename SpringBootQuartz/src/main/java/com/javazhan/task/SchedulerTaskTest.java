package com.javazhan.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yando on 2017/11/23.
 */
@Component  // 实例化对象到Spring容器
public class SchedulerTaskTest {

    private static int count = 0 ;

    @Scheduled(cron = "*/5 * * * * ?")   //每5秒执行一次
    public void process() {
        DateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date())+" 任务执行次数："+(count++));
    }

}
