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
        String convertedIp = getConvertedIp(ip);
        return repository.findByIpFrom(convertedIp);
    }

    /**
     *
     * @param ip
     * @return
     */
    @Override
    public Geo findByIpTo(String ip){
        String convertedIp = getConvertedIp(ip);
        return repository.findByIpTo(convertedIp);
    }

    /**
     * Description: Load the db from the .csv data
     * @return
     */
    @Override
    public String loadDBFromCSV() {
        String line = "";
        String splitBy = ",";
        List<Geo> geoList = new ArrayList<>();
        Geo geoReg;
        Integer id = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/db/ipgeo.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] geoLine = line.split(splitBy);
                if(!geoLine[0].contains("IP_from")){
                    geoReg = new Geo(id, geoLine[0], geoLine[1], geoLine[2], geoLine[3], geoLine[4], geoLine[5],
                            geoLine[6], geoLine[7], geoLine[8]);
                    geoList.add(geoReg);
                    id++;
                }
            }
            saveAll(geoList);

        }
        catch(IOException e) {
            e.printStackTrace();
            return "Error loading the database";
        }

        return "Data was loaded!!";
    }

    /**
     * Description: Get the converted ip for querying in database
     * @param ip
     * @return
     */
    private String getConvertedIp(String ip) {
        String[] convertedIpSplit = ip.split("\\.");
        String convertedIp = String.valueOf(
                Long.parseLong(convertedIpSplit[0]) * 16777216 + Long.parseLong(convertedIpSplit[1]) * 65536 +
                        Long.parseLong(convertedIpSplit[2]) * 256 + Long.parseLong(convertedIpSplit[3]));
        return convertedIp;
    }


}
