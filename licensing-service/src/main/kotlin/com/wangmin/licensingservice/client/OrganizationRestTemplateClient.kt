package com.wangmin.licensingservice.client

import com.wangmin.licensingservice.model.Organization
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class OrganizationRestTemplateClient(
    private val restTemplate: RestTemplate,
) {
    fun getOrganization(organizationId: String): Organization? {
        val serviceUri = "http://organization-service/v1/organization/$organizationId"

        val response = restTemplate.exchange(serviceUri, HttpMethod.GET, null, Organization::class.java, organizationId)
        return response.body
    }
}
