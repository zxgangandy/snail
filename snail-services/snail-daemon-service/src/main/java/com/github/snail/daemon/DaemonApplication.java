

package com.github.snail.daemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DaemonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaemonApplication.class, args);
    }

}
