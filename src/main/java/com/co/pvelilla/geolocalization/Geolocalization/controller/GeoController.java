package com.co.pvelilla.geolocalization.Geolocalization.controller;

import com.co.pvelilla.geolocalization.Geolocalization.dto.GeoDto;
import com.co.pvelilla.geolocalization.Geolocalization.service.GeoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping("api/v1/geolocalization")
public class GeoController {

    private final GeoService geoService;
    private final ModelMapper modelMapper;

    @Autowired
    public GeoController(final GeoService geoService, final ModelMapper modelMapper){
        this.geoService = geoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/health")
    public String health(){
        return "Ok!";
    }

    @GetMapping(value = "/getGeoByIpFrom/{ip}")
    public ResponseEntity<GeoDto> findByIpFrom(@PathVariable String ip){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(geoService.findByIpFrom(ip), GeoDto.class));
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @GetMapping(value = "/getGeoByIpTo/{ip}")
    public ResponseEntity<GeoDto> findByIpTo(@PathVariable String ip){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(geoService.findByIpTo(ip), GeoDto.class));
        }catch (Exception e){
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @GetMapping(value = "/load")
    public String loadDB() {
        return geoService.loadDBFromCSV();
    }


}
