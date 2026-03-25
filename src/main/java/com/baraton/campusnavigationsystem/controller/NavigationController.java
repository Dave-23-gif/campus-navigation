package com.baraton.campusnavigationsystem.controller;

import com.baraton.campusnavigationsystem.service.NavigationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/navigation")
@RequiredArgsConstructor
public class NavigationController {


    private final NavigationService navigationService;


    @GetMapping("/route")
    public String getRoute(@RequestParam String start,
                           @RequestParam String end) {

        return navigationService.findShortestPath(start, end);
    }
}

