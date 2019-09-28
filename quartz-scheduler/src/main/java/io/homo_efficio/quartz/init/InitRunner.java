package io.homo_efficio.quartz.init;

import io.homo_efficio.quartz.config.RemoteJobClassLoader;
import io.homo_efficio.quartz.job.SimpleJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-27
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class InitRunner implements CommandLineRunner {

    private final Scheduler scheduler;
    private final RemoteJobClassLoader remoteJobClassLoader;

    @Override
    public void run(String... args) throws Exception {
        log.info("Init Runner executed.");
        JobKey jobKey = JobKey.jobKey("jobkey1", "jobgroup1");
        JobDetail jobDetail = buildJobDetail(jobKey);
        Trigger trigger = buildJobTrigger(jobKey);
        scheduler.scheduleJob(jobDetail, trigger);
    }

    private JobDetail buildJobDetail(JobKey jobKey) throws ClassNotFoundException {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("key1", "value1");
        jobDataMap.put("key2", 2);
        Class<? extends Job> loadedClass = remoteJobClassLoader.loadClass("io.homo_efficio.quartz.job.RemoteSimpleJob", Job.class);
        return JobBuilder.newJob(loadedClass)
                .withIdentity(jobKey)
                .withDescription("Simple Quartz Job Detail")
                .usingJobData(jobDataMap)
                .build();
    }

    private Trigger buildJobTrigger(JobKey jobKey) {
        return TriggerBuilder.newTrigger()
                .forJob(jobKey)
                .withDescription("Simple Quartz Job Trigger")
                .startNow()
                .build();
    }
}
