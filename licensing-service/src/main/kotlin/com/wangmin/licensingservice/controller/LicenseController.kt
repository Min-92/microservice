package com.wangmin.licensingservice.controller

import com.wangmin.licensingservice.model.License
import com.wangmin.licensingservice.service.LicenseService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/organization/{organizationId}/license")
class LicenseController(
    private val licenseService: LicenseService,
) {
    @GetMapping("{licenseId}")
    fun getLicense(
        @PathVariable licenseId: String,
        @PathVariable organizationId: String,
    ): License {
        return licenseService.getLicense(licenseId, organizationId)
    }

    @PutMapping
    fun updateLicense(
        @RequestBody request: License,
        @PathVariable organizationId: String,
    ): License {
        return licenseService.updateLicense(request, organizationId)
    }

    @PostMapping
    fun createLicense(
        @RequestBody request: License,
        @PathVariable organizationId: String,
    ): License {
        return licenseService.createLicense(request.also { it.organizationId = organizationId })
    }

    @DeleteMapping("{licenseId}")
    fun deleteLicense(
        @PathVariable licenseId: String,
        @PathVariable organizationId: String,
    ): String {
        return licenseService.deleteLicense(licenseId, organizationId)
    }
}
