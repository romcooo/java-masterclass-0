package com.romco.oreillyrestexample.controller;

import com.romco.oreillyrestexample.entities.Site;
import com.romco.oreillyrestexample.json.Response;
import com.romco.oreillyrestexample.service.GeocoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestGeoController {
    // == fields
    private final GeocoderService service;
    
    // == constructors
    @Autowired
    public RestGeoController(GeocoderService service) {
        this.service = service;
    }
    
    @GetMapping("/geo")
    public Site getSite(@RequestParam(required = true) String address) {
        Site site = service.getLatLng(address);
        return site;
    }
    

}
