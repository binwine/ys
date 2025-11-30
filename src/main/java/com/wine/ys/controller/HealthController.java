package com.wine.ys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 心跳检测
 */
@RestController
@RequestMapping("/health")
@Slf4j
public class HealthController {

    @GetMapping
    public String checkHealth(){
        log.info("心跳测试");
        String mm = "11";

        log.info("param:{}", mm);
        return "success1";
    }
}
