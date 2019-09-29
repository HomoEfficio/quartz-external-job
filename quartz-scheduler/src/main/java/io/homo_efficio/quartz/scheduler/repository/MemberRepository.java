package io.homo_efficio.quartz.scheduler.repository;

import io.homo_efficio.quartz.scheduler.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-29
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
