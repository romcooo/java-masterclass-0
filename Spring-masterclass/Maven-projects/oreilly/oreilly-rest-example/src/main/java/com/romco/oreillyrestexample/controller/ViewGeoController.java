package com.romco.oreillyrestexample.controller;

import com.romco.oreillyrestexample.entities.Site;
import com.romco.oreillyrestexample.service.GeocoderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class ViewGeoController {
    // == fields
    private final GeocoderService service;
    
    // == constructor
    @Autowired
    public ViewGeoController(GeocoderService service) {
        this.service = service;
    }
    
    // == mappings
    @GetMapping("/siteQuery")
    public String getSiteAsString(@RequestParam(required = true) String address, Model model) {
        Site site = service.getLatLng(address);
        model.addAttribute("site", site.toString());
        log.info("in getSiteAsString, " + model.toString());
        return "site";
    }
    
    @GetMapping("/test")
    public String testGet(Model model) {
        Site site = service.getLatLng("Prazska+4+Brno");
        model.addAttribute("site", site.toString());
        return "site";
    }
    
}
