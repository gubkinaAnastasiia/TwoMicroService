package com.example.comprassiondate.service;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class ComparisonDateService {

    private final WebClient webClient;

    public String getCurrentTime() {

        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/current_time")
                    .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

    }

    public String comparisonDate(String givenDate) {

        String localDate = getCurrentTime();

        int[] array_localDate = Arrays.stream(localDate.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] array_givenDate = Arrays.stream(givenDate.split("\\.")).mapToInt(Integer::parseInt).toArray();


        String result;
        if (array_localDate[2] < array_givenDate[2]) {
            result = ("Данная дата еще не настала");
        } else if (array_localDate[2] > array_givenDate[2]) {
            result = ("Данная дата уже прошла");
        } else {
            if (array_localDate[1] < array_givenDate[1]) {
                result = ("Данная дата еще не настала");
            } else if (array_localDate[1] > array_givenDate[1]) {
                result = ("Данная дата уже прошла");
            } else {
                if (array_localDate[0] < array_givenDate[0]) {
                    result = ("Данная дата еще не настала");
                } else if (array_localDate[0] > array_givenDate[0]) {
                    result = ("Данная дата уже прошла");
                } else {
                    result = "Сегодня данная дата";
                }
            }
        }
        return result;
    }
}
