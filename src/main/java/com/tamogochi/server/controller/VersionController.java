package com.tamogochi.server.controller;

import com.tamogochi.server.configuration.VersionProperties;
import com.tamogochi.server.dto.entity.VersionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/version")
@RequiredArgsConstructor
public class VersionController {

    private final VersionProperties versionProperties;

    @GetMapping
    public VersionDto version() {
        return new VersionDto(versionProperties.format());
    }
}
