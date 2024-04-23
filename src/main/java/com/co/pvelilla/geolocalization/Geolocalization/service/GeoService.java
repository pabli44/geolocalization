package com.co.pvelilla.geolocalization.Geolocalization.service;

import com.co.pvelilla.geolocalization.Geolocalization.entity.Geo;

import java.util.List;

public interface GeoService {

    void saveAll(List<Geo> geoList);

    Geo findByIpFrom(String ip);

    Geo findByIpTo(String ip);

    String loadDBFromCSV();

    boolean validateIp(String ip);

}
