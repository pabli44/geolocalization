package com.co.pvelilla.geolocalization.Geolocalization.service.impl;

import com.co.pvelilla.geolocalization.Geolocalization.entity.Geo;
import com.co.pvelilla.geolocalization.Geolocalization.repository.GeoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class GeoServiceImplTest {

    @Mock
    private GeoRepository geoRepository;

    @InjectMocks
    private GeoServiceImpl geoService;

    private static final int ID = 1;
    private static final String IP_FROM = "1.0.4.0";
    private static final String IP_TO = "1.0.5.255";
    private static final String IP_DECIMAL_FROM = "16778240";
    private static final String IP_DECIMAL_TO = "16778751";
    private static final String COUNTRY_CODE = "AU";
    private static final String COUNTRY = "AUSTRALIA";
    private static final String REGION = "VICTORIA";
    private static final String CITY = "ADELAIDE";
    private static final String LATITUDE = "-34.9258";
    private static final String LONGITUDE = "138.6";
    private static final String TIME_ZONE = "BIG RED GROUP";

    private static final int ID2 = 1;
    private static final String IP_FROM2 = "192.168.20.30";
    private static final String IP_TO2 = "192.168.20.49";
    private static final String COUNTRY_CODE2 = "AE";
    private static final String COUNTRY2 = "AUSTRALIA2";
    private static final String REGION2 = "VICTORIA2";
    private static final String CITY2 = "ADELAIDE2";
    private static final String LATITUDE2 = "-67.998";
    private static final String LONGITUDE2 = "45.987";
    private static final String TIME_ZONE2 = "BIG RED GROUP2";


    @BeforeEach
    public void setup(){
        geoRepository = Mockito.mock(GeoRepository.class);
        geoService = new GeoServiceImpl(geoRepository);
    }
    @Test
    void saveAll() {
        Geo geo1 = createGeo(ID, IP_FROM, IP_TO, COUNTRY_CODE, COUNTRY,
                REGION, CITY, LATITUDE, LONGITUDE, TIME_ZONE);

        Geo geo2 = createGeo(ID2, IP_FROM2, IP_TO2, COUNTRY_CODE2, COUNTRY2,
                REGION2, CITY2, LATITUDE2, LONGITUDE2, TIME_ZONE2);

        List<Geo> geoList = new ArrayList<>();
        geoList.add(geo1);
        geoList.add(geo2);

        geoRepository.saveAll(geoList);

        assertEquals(geoList.size(), 2);
        assertEquals(geoList.get(0).getId(), ID);
        assertEquals(geoList.get(1).getCountry(), COUNTRY2);
    }

    @Test
    void findByIpFrom() {
        Geo geo = createGeo(ID, IP_DECIMAL_FROM, IP_DECIMAL_TO, COUNTRY_CODE, COUNTRY,
                REGION, CITY, LATITUDE, LONGITUDE, TIME_ZONE);
        geoRepository.save(geo);
        when(geoRepository.findByIpFrom(IP_DECIMAL_FROM)).thenReturn(geo);
        Geo geoQuery = geoService.findByIpFrom(IP_FROM);

        assertEquals(geoQuery.getCity(), CITY);
    }

    @Test
    void findByIpTo() {
        Geo geo = createGeo(ID, IP_DECIMAL_FROM, IP_DECIMAL_TO, COUNTRY_CODE, COUNTRY,
                REGION, CITY, LATITUDE, LONGITUDE, TIME_ZONE);
        geoRepository.save(geo);
        when(geoRepository.findByIpTo(IP_DECIMAL_TO)).thenReturn(geo);
        Geo geoQuery = geoService.findByIpTo(IP_TO);

        assertEquals(geoQuery.getCity(), CITY);
    }

    private Geo createGeo(Integer id, String ipFrom, String ipTo, String countryCode, String country,
                          String region, String city, String latitude, String longitude, String timeZone){
        return new Geo(id, ipFrom, ipTo, countryCode, country, region, city, latitude, longitude, timeZone);
    }
}