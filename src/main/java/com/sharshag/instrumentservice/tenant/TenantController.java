package com.sharshag.instrumentservice.tenant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharshag.instrumentservice.multitenancy.context.TenantContext;

@RestController
@RequestMapping("tenant")
public class TenantController {

    @GetMapping
    public String getTenant() {
        return TenantContext.getTenantId();
    }
    
}
