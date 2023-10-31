package com.wangmin.licensingservice.service

import com.wangmin.licensingservice.client.OrganizationDiscoveryClient
import com.wangmin.licensingservice.client.OrganizationRestTemplateClient
import com.wangmin.licensingservice.model.License
import com.wangmin.licensingservice.model.Organization
import com.wangmin.licensingservice.repository.LicenseRepository
import org.springframework.stereotype.Service

@Service
class LicenseService(
    private val licenseRepository: LicenseRepository,
    private val organizationDiscoveryClient: OrganizationDiscoveryClient,
    private val organizationRestTemplateClient: OrganizationRestTemplateClient,
) {
    fun getLicense(licenseId: String, organizationId: String): License =
        licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId)

    fun getLicense(licenseId: String, organizationId: String, clientType: String): License {
        val license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId)
        val organization = retrieveOrganizationInfo(organizationId, clientType)

        if (organization != null) {
            license.organizationName = organization.name
            license.contactEmail = organization.contactEmail
            license.contactName = organization.contactName
            license.contactPhone = organization.contactPhone
        }

        return license
    }

    fun retrieveOrganizationInfo(
        organizationId: String,
        clientType: String,
    ): Organization? {
        when (clientType) {
            "discovery" -> return organizationDiscoveryClient.getOrganization(organizationId)
            "rest" -> return organizationRestTemplateClient.getOrganization(organizationId)
        }
        return null
    }

    fun createLicense(license: License): License {
        val saved = licenseRepository.save(license)
        println("This is the POST and the object is : $saved")
        return saved
    }

    fun updateLicense(license: License, organizationId: String): License {
        val saved = licenseRepository.save(license)

        println("This is the PUT and the object is : $license")
        return saved
    }

    fun deleteLicense(licenseId: String, organizationId: String): String {
        val found = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId)
        licenseRepository.delete(found)
        return "Deleting license with id : $licenseId for the organization : $organizationId"
    }
}
