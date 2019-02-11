

package com.github.snail.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.ZipkinServer;


@EnableDiscoveryClient
//@SpringBootApplication
//@EnableZipkinServer
public class ZipkinDbApplication extends ZipkinServer {
    public static void main(String[] args) {
        SpringApplication.run(ZipkinDbApplication.class, args);
    }
}
