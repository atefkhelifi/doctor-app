package org.sid.controller;

import org.sid.service.GeoapifyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DoctorLocatorController {

    private final GeoapifyService geoapifyService;

    public DoctorLocatorController(GeoapifyService geoapifyService) {
        this.geoapifyService = geoapifyService;
    }

    @GetMapping("/nearby-doctors")
    public ResponseEntity<?> getNearbyDoctors(
            @RequestParam("lat") double latitude,
            @RequestParam("lon") double longitude) {
        
        String result = geoapifyService.findNearbyDoctors(latitude, longitude);
        return ResponseEntity.ok(result);
    }
}