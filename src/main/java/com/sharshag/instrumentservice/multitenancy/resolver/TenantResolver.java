package com.sharshag.instrumentservice.multitenancy.resolver;

import org.springframework.lang.NonNull;

public interface TenantResolver<T> {
    
    String resolveTenantId(@NonNull T object);
}
