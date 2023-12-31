package com.sharshag.instrumentservice.multitenancy.web;

import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.ServerHttpObservationFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sharshag.instrumentservice.multitenancy.context.TenantContext;
import com.sharshag.instrumentservice.multitenancy.resolver.HttpHeaderTenantResolver;

import io.micrometer.common.KeyValue;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TenantInterceptor implements HandlerInterceptor {

    private final HttpHeaderTenantResolver tenantResolver;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String resolveTenantId = tenantResolver.resolveTenantId(request);
        TenantContext.setTenantId(resolveTenantId);
        MDC.put("tenantId", resolveTenantId);
        ServerHttpObservationFilter.findObservationContext(request).ifPresent(context -> context.addHighCardinalityKeyValue(KeyValue.of("tenant.id",resolveTenantId)));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {

        clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {

        clear();
    }

    private void clear() {
        TenantContext.clear();
        MDC.clear();
    }
}
