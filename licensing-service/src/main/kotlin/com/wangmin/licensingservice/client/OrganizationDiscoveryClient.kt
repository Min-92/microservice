package com.wangmin.licensingservice.client

import com.wangmin.licensingservice.model.Organization
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class OrganizationDiscoveryClient(
    private val discoveryClient: DiscoveryClient,
) {
    fun getOrganization(organizationId: String): Organization? {
        val restTemplate = RestTemplate()
        val instances = discoveryClient.getInstances("organization-service")

        if (instances.size == 0) return null
        val serviceUri = "${instances[0].uri}/v1/organization/$organizationId"

        val response = restTemplate.exchange(serviceUri, HttpMethod.GET, null, Organization::class.java, organizationId)
        return response.body
    }
}
