package com.wangmin.licensingservice.service

import com.wangmin.licensingservice.model.License
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class LicenseService {
    fun getLicense(licenseId: String, organizationId: String): License {
        return License(
            id = Random.nextInt(),
            licenseId = licenseId,
            organizationId = organizationId,
            description = "Software product",
            productName = "Ostock",
            licenseType = "full",
        )
    }

    fun createLicense(license: License, organizationId: String): String {
        return "This is the POST and the object is : $license"
    }

    fun updateLicense(license: License, organizationId: String): String {
        return "This is the PUT and the object is : $license"
    }

    fun deleteLicense(licenseId: String, organizationId: String): String {
        return "Deleting license with id : $licenseId for the organization : $organizationId"
    }
}
