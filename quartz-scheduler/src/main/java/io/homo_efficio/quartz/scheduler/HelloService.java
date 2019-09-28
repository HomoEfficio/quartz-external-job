package io.homo_efficio.quartz.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-28
 */
@Service
@Slf4j
public class HelloService {

    public void sayHello() {
        log.info("OOO {}.sayHello() executed", this.getClass().getSimpleName());
    }
}
