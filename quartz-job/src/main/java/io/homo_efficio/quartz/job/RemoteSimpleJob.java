package io.homo_efficio.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-28
 */
public class RemoteSimpleJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println(this.getClass().getSimpleName() + " executed.");
    }
}
