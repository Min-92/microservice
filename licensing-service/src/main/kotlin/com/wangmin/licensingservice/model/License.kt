package com.wangmin.licensingservice.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "licenses")
data class License(
    @Id
    val licenseId: String,
    val description: String,
    var organizationId: String,
    val productName: String,
    val licenseType: String,

    @Transient
    var organizationName: String,

    @Transient
    var contactName: String,

    @Transient
    var contactPhone: String,

    @Transient
    var contactEmail: String,
)
