package io.homo_efficio.quartz.job;

import io.homo_efficio.quartz.scheduler.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-28
 */
@Slf4j
public class RemoteSimpleJob implements Job {

    @Autowired
    private HelloService helloService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("OOO {} executed..", this.getClass().getSimpleName());
        helloService.sayHello();
    }
}
