package com.co.pvelilla.geolocalization.Geolocalization.repository;

import com.co.pvelilla.geolocalization.Geolocalization.entity.Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeoRepository extends JpaRepository<Geo, Integer> {

    List<Geo> findAll();

    Geo findByIpFrom(String ip);

    Geo findByIpTo(String ip);

}
