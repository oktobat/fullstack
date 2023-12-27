package com.office.library.controller;

import java.util.HashMap;
import java.util.Map;

import com.office.library.service.KakaoMapService;
import com.office.library.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    KakaoMapService kakaoMapService;
    @Autowired
    WeatherService weatherService;
    @GetMapping("/getPosition")
    public String getPosition(@RequestParam("address") String address) {
        Double lon = 127.0495556;
        Double lat = 37.514575;
        if (address != null && !address.isEmpty()) {
            String[] addr = address.split(" ");
            address = addr[0]+" "+addr[1]+" "+addr[2];
            Map<String, Double> pos = kakaoMapService.getAddressCoordinates(address);
            System.out.println("위도"+pos.get("lat"));
            System.out.println("경도"+pos.get("lon"));
            lat = pos.get("lat");
            lon = pos.get("lon");
        }
        String weatherResponse = weatherService.getWeatherData(lat, lon);
        System.out.println(weatherResponse);
        return weatherResponse;
    }

}
