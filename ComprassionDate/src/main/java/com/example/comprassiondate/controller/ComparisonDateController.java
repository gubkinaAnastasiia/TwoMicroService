package com.example.comprassiondate.controller;

import com.example.comprassiondate.service.ComparisonDateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ComparisonDateController {

    private final ComparisonDateService service;

    @GetMapping("/comparison_date/{givenDate}")
    public String comparisonDate(@PathVariable String givenDate) {
        return service.comparisonDate(givenDate);
    }

}
