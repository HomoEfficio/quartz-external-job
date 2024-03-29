package io.homo_efficio.quartz.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-27
 */
@Component
@Slf4j
public class RemoteJobClassLoader {

    private static final String JOB_REPO = "/tmp/homo-efficio/quartz/remote-job-repo/quartz-job.jar";

    @SuppressWarnings("unchecked")
    public <T> Class<? extends T> loadClass(String name, Class<T> clazz) throws ClassNotFoundException {
        return (Class<? extends T>) getClassLoader().loadClass(name);
    }

    private ClassLoader getClassLoader() {
        try {
            return new URLClassLoader(
                    new URL[] {
                            new File(JOB_REPO).toURI().toURL()
                    },
                    // URLClassLoader 설정 시 parent를 webAppClassLoader로 지정해줘야
                    // org.quartz.Job 등 내부 의존 클래스 로딩 가능
                    this.getClass().getClassLoader()
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
