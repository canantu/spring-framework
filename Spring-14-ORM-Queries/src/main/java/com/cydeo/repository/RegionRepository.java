package com.cydeo.repository;

import com.cydeo.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    // display all regions belongs to Canada
    List<Region> findByCountry(String country);

    // display all regions in Canada without duplicates
    List<Region> findDistinctByCountry(String country);

    // display all regions with country include "United"
    List<Region> findByCountryContaining(String country);

    // display all regions with country name includes "United" in order
    List<Region> findByCountryContainingOrderByCountry(String country);

    // display top two regions in Canada
    List<Region> findTop2ByCountry(String country);

}
