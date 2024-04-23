package com.co.pvelilla.geolocalization.Geolocalization.service.impl;

import com.co.pvelilla.geolocalization.Geolocalization.entity.Geo;
import com.co.pvelilla.geolocalization.Geolocalization.repository.GeoRepository;
import com.co.pvelilla.geolocalization.Geolocalization.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeoServiceImpl implements GeoService {

    @Autowired
    GeoRepository repository;

    @Override
    public void saveAll(List<Geo> geoList) {
        repository.saveAll(geoList);
    }

    @Override
    public Geo findByIpFrom(String ip){
        return repository.findByIpFrom(ip);
    }

    @Override
    public Geo findByIpTo(String ip){
        return repository.findByIpTo(ip);
    }

    @Override
    public String loadDB() {
        String line = "";
        String splitBy = ",";
        List<Geo> geoList = new ArrayList<>();
        Geo geoReg;
        int counter = 0;
        Integer id = 0;

        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/db/ipgeo.csv"));
            while ((line = br.readLine()) != null)
            //returns a Boolean value
            {
                String[] geoLine = line.split(splitBy);
                if(!geoLine[0].contains("IP_from")){
                    //use comma as separator
                    geoReg = new Geo(id, geoLine[0], geoLine[1], geoLine[2], geoLine[3], geoLine[4], geoLine[5], geoLine[6], geoLine[7], geoLine[8]);
                    geoList.add(geoReg);
                    id++;
                }
                counter ++;
            }
            saveAll(geoList);

        }
        catch(IOException e) {
            e.printStackTrace();
            return "Error loading the database";
        }

        return "Data was loaded!!";
    }


}
