package io.homo_efficio.quartz.scheduler;

import io.homo_efficio.quartz.scheduler.entity.Member;
import io.homo_efficio.quartz.scheduler.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-28
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class HelloService {

    private final MemberRepository memberRepository;

    public void sayHello() {
        log.info("OOO {}.sayHello() executed", this.getClass().getSimpleName());
    }

    @Transactional
    public Member saveMember(Member member) {
        Member dbMember = memberRepository.save(member);
        if (1==1) {
            throw new RuntimeException("테스트를 위해 강제로 발생시킨 예외");
        }
        return dbMember;
    }
}
