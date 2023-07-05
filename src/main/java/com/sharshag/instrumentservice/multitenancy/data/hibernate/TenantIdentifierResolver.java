package com.sharshag.instrumentservice.multitenancy.data.hibernate;

import java.util.Map;
import java.util.Objects;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import com.sharshag.instrumentservice.multitenancy.context.TenantContext;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer {

    @Override
    public  String resolveCurrentTenantIdentifier() {
        return Objects.requireNonNullElse(TenantContext.getTenantId(), "PUBLIC");
    }

    @Override
    public  boolean validateExistingCurrentSessions() {
        return false;
    }

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
    }
    
}
