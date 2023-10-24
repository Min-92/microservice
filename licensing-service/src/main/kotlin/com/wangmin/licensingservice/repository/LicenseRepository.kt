package com.wangmin.licensingservice.repository

import com.wangmin.licensingservice.model.License
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LicenseRepository : JpaRepository<License, Int> {
    fun findByOrganizationId(organizationId: String): List<License>
    fun findByOrganizationIdAndLicenseId(organizationId: String, licenseId: String): License
}
