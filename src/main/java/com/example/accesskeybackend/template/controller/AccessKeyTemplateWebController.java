package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.dto.AccessKeyWebDto;
import com.example.accesskeybackend.template.service.AccessKeyWebService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/web/checkIpv6Support")
@AllArgsConstructor
public class AccessKeyTemplateWebController {
    private final AccessKeyWebService service;
    @GetMapping
    public AccessKeyWebDto checkIpv6Support(@RequestBody String  siteUrl) throws Exception {
        return service.checkIpv6Support(siteUrl);
    }
}
