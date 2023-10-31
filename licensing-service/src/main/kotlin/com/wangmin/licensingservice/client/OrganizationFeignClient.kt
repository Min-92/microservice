package com.wangmin.licensingservice.client

import com.wangmin.licensingservice.model.Organization
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("organization-service")
interface OrganizationFeignClient {

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/v1/organization/{organizationId}"],
        consumes = ["application/json"],
    )
    fun getOrganization(@PathVariable organizationId: String): Organization?
}
