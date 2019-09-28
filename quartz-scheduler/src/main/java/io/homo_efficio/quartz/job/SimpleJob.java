package io.homo_efficio.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-27
 */
@Slf4j
public class SimpleJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("OOO JOB [{}] executed.", this.getClass().getSimpleName());
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        mergedJobDataMap.forEach((k, v) -> log.info("OOOOO {}: {}", k, v));
    }
}
