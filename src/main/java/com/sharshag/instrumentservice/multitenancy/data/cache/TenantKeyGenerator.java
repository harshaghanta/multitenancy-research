package com.sharshag.instrumentservice.multitenancy.data.cache;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.stereotype.Component;

import com.sharshag.instrumentservice.multitenancy.context.TenantContext;

@Component
public class TenantKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return SimpleKeyGenerator.generateKey(TenantContext.getTenantId(), params);
    }
    
}
