package io.homo_efficio.quartz.config;

import org.quartz.Scheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-29
 */
//@Configuration
public class QuartzConfig {

    @Bean
    public Scheduler scheduler(ApplicationContext applicationContext) {
        SchedulerFactoryBean schedulerFactoryBean = getSchedulerFactoryBean(applicationContext);
        return schedulerFactoryBean.getScheduler();
    }

    private SchedulerFactoryBean getSchedulerFactoryBean(ApplicationContext applicationContext) {
        QuartzJobFactory quartzJobFactory = new QuartzJobFactory();
        quartzJobFactory.setApplicationContext(applicationContext);

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setJobFactory(quartzJobFactory);
//        schedulerFactoryBean.setXXX(...);

        return schedulerFactoryBean;
    }
}
