package com.example.currenttime.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CurrentTimeService {

    public String getCurrentTime() {
        LocalDateTime time = LocalDateTime.now();
        StringBuilder string_lt = new StringBuilder();
        if (time.getDayOfMonth() < 10) {
            string_lt.append("0");
        }
        string_lt.append(time.getDayOfMonth());
        string_lt.append(".");
        if (time.getMonthValue() < 10) {
            string_lt.append("0");
        }
        string_lt.append(time.getMonthValue());
        string_lt.append(".");
        string_lt.append(time.getYear());

        return string_lt.toString();
    }
}
