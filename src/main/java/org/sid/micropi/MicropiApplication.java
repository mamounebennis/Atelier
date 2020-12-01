package org.sid.micropi;

import org.sid.micropi.entities.AppRole;
import org.sid.micropi.entities.AppUser;
import org.sid.micropi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class MicropiApplication{
    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(MicropiApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}








