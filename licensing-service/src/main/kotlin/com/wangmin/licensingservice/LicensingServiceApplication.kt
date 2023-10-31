package com.wangmin.licensingservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class LicensingServiceApplication

fun main(args: Array<String>) {
    runApplication<LicensingServiceApplication>(*args)
}
