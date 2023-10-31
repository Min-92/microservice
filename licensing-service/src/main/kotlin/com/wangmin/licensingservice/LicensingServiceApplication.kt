package com.wangmin.licensingservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableDiscoveryClient // discovery client
@EnableFeignClients // Feign client
class LicensingServiceApplication {
    @Bean
    @LoadBalanced // load balanced rest template
    fun getRestTemplate(): RestTemplate = RestTemplate()
}

fun main(args: Array<String>) {
    runApplication<LicensingServiceApplication>(*args)
}
