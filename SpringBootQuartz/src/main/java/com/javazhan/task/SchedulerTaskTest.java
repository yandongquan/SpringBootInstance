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
    public void cronProcess() {
        DateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date())+" 任务执行次数："+(count++));
    }

    @Scheduled(fixedRate = 5000)   //上一次开始执行时间点之后5秒再执行
    public void fixedRatepProcess() {
        DateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date())+" fixedRatepProcess任务执行次数："+(count++));
    }

    @Scheduled(fixedDelay = 5000)   //上一次执行完毕时间点之后5秒再执行
    public void fixedDelayProcess() {
        DateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date())+" fixedDelayProcess任务执行次数："+(count++));
    }

    @Scheduled(initialDelay = 1000, fixedRate = 5000)   //第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
    public void initialDelayProcess() {
        DateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date())+" initialDelayProcess任务执行次数："+(count++));
    }

}
