package com.sharshag.instrumentservice.multitenancy;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * TenantHttpProperties
 */
@ConfigurationProperties(prefix = "multitenancy.http")
public record TenantHttpProperties(String headerName) {
}