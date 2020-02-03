package com.romco.oreillyrestexample.service;

import com.romco.oreillyrestexample.entities.Site;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ExtendWith(SpringExtension.class)
class GeocoderServiceTest {
    
    @Autowired
    private GeocoderService service;
    
    @Test
    void getLatLngForGoogleHQ() {
        Site google = service.getLatLng("1600 Amphitheatre Parkway", "Mountain View", "CA");
        log.info(google.toString());
        assertEquals(37.42, google.getLatitude(), 0.01);
        assertEquals(-122.08, google.getLongitude(), 0.01);
    }
    
    @Test
    void getLatLng() {
    
    }
}