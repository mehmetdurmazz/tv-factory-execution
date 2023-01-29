package com.ceb.tvfactoryexecution.feature.factory.controller;

import com.ceb.tvfactoryexecution.feature.factory.TVFactoryExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/factory")
public class TVFactoryController {

    private final TVFactoryExecutor tvFactoryExecutor;

    @GetMapping("/execute")
    public void execute() {
        tvFactoryExecutor.execute();
    }

}
