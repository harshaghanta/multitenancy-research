package com.sharshag.instrumentservice.multitenancy.resolver;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.sharshag.instrumentservice.multitenancy.TenantHttpProperties;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class HttpHeaderTenantResolver implements TenantResolver<HttpServletRequest> {

    private final TenantHttpProperties tenantHttpProperties;


    public String resolveTenantId(@NonNull HttpServletRequest request) {
        return request.getHeader(tenantHttpProperties.headerName());

    }
}
