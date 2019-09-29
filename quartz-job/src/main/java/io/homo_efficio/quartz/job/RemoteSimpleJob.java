package io.homo_efficio.quartz.job;

import io.homo_efficio.quartz.scheduler.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-28
 */
@Slf4j
@RequiredArgsConstructor
public class RemoteSimpleJob implements Job {

    private final HelloService helloService;


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("OOO REMOTE JOB [{}] executed.", this.getClass().getSimpleName());
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        mergedJobDataMap.forEach((k, v) -> log.info("OOOOO {}: {}", k, v));

        helloService.sayHello();
    }
}
