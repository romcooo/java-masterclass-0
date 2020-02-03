package com.romco.oreillyrestexample.service;

import com.romco.oreillyrestexample.entities.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.romco.oreillyrestexample.json.Response;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GeocoderService {
    private static final String BASE = "https://maps.googleapis.com/maps/api/geocode/json";
    public static final String KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";
    
    private RestTemplate restTemplate;
    
    @Autowired
    public GeocoderService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }
    
    public Site getLatLng(String... addresses) {
        String joinedAddress = String.join(",", addresses);
        String encodedAddress = "";
        encodedAddress = URLEncoder.encode(joinedAddress, StandardCharsets.UTF_8);
  
        Response response = restTemplate.getForObject(String.format("%s?address=%s&key=%s",
                                                                    BASE,
                                                                    encodedAddress,
                                                                    KEY),
                                                      Response.class);
        return new Site(response.getFormattedAddress(),
                        response.getLocation().getLat(),
                        response.getLocation().getLng());
    }
    
}
