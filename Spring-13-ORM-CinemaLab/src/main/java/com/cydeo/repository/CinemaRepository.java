package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findById(Long aLong);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByLocation_Country(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findAllByNameOrSponsoredName(String name, String sponsoredName);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c.name FROM Cinema c WHERE c.id = ?1")
    Cinema fetchById(Long id);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * FROM cinema c JOIN location l ON c.location_id = l.id WHERE l.country = ?1",nativeQuery = true)
    List<Cinema> retriveAllBasedOnLocationCountry(String country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM cinema WHERE name ILIKE concat('%', ?1, '%') " +
            "OR sponsored_name ILIKE concat('%', ?1, '%') ", nativeQuery = true)
    List<Cinema> retrieveAllByNameOrSponsoredNameContaining(String pattern);
    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM cinema ORDER BY name" ,nativeQuery = true)
    List<Cinema> sortByName();
    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT Distinct sponsored_name From cinema", nativeQuery = true)
    List<Cinema> distinctSponsoredName();
}