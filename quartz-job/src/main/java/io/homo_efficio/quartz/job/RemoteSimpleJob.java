package io.homo_efficio.quartz.job;

import io.homo_efficio.quartz.scheduler.HelloService;
import io.homo_efficio.quartz.scheduler.entity.Member;
import io.homo_efficio.quartz.scheduler.repository.MemberRepository;
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
    private final MemberRepository memberRepository;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("OOO REMOTE JOB [{}] executed.", this.getClass().getSimpleName());
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        mergedJobDataMap.forEach((k, v) -> log.info("OOOOO {}: {}", k, v));

        helloService.sayHello();

        try {
            Member dbMember = memberRepository.save(new Member("Homo Efficio", "homo.efficio@gmail.com"));
            log.info("TTT 회원 [{}] 추가됨", dbMember);
            if (1==1) {
                throw new RuntimeException("테스트를 위해 강제로 발생시킨 예외");
            }
        } catch (Exception e) {
            log.error("TTT 회원 추가 중 예외 발생. 메시지: {}",e.getMessage());
        }
    }
}
