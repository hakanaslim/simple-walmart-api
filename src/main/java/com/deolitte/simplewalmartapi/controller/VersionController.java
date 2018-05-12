package com.deolitte.simplewalmartapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/version", method = RequestMethod.OPTIONS)
public class VersionController {

    @Value("${version}")
    public String version;

    @GetMapping
    public String getVersion() {
        return version;
    }
}
