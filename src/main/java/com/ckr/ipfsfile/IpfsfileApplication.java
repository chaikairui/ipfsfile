package com.ckr.ipfsfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class IpfsfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpfsfileApplication.class, args);
    }

}
