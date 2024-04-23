package com.co.pvelilla.geolocalization.Geolocalization.dto;

import lombok.Data;

@Data
public class GeoDto {

    private Integer id;

    private String countryCode;

    private String region;

    private String city;

    private String timeZone;

}
