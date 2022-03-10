package com.example.configclientexample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marathoner on 2022/03/10
 */
@RestController
@RequestMapping("/api/v1/config-test")
@RefreshScope
public class ConfigClientController {

    @Value("${namoosori.value}")
    private String configStr;

    @GetMapping
    public String test() {
        return configStr;
    }

}
