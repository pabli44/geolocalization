package com.co.pvelilla.geolocalization.Geolocalization.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Geo {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IP_from")
    private String ipFrom;

    @Column(name = "IP_to")
    private String ipTo;

    @Column(name = "Country_code")
    private String countryCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "Region")
    private String region;

    @Column(name = "City")
    private String city;

    @Column(name = "Latitude")
    private String latitude;

    @Column(name = "Longitude")
    private String longitude;

    @Column(name = "TimeZone")
    private String timeZone;

}
