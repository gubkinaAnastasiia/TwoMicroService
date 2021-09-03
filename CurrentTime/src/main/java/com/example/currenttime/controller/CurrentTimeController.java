package com.example.currenttime.controller;

import com.example.currenttime.service.CurrentTimeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CurrentTimeController {

    private final CurrentTimeService service;

    @GetMapping("/current_time")
    public String getCurrentTime() {
        return service.getCurrentTime();
    }
}
