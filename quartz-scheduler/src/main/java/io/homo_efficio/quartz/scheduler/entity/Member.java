package io.homo_efficio.quartz.scheduler.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author homo.efficio@gmail.com
 * created on 2019-09-29
 */
@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    protected Member() {
    }

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
