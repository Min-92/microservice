package com.wangmin.licensingservice.service

import com.wangmin.licensingservice.model.License
import com.wangmin.licensingservice.repository.LicenseRepository
import org.springframework.stereotype.Service

@Service
class LicenseService(
    private val licenseRepository: LicenseRepository,
) {
    fun getLicense(licenseId: String, organizationId: String): License =
        licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId)

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
