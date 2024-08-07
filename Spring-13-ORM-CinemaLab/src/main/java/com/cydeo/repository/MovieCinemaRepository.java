package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countAllByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime localDateTime);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findFirst3ByOrderByMoviePriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovie_NameContaining(String name);
    //Write a derived query to list all movie cinemas in a specific location
    List<MovieCinema> findAllByCinema_Location_Name(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date

    @Query("select mc from MovieCinema mc where mc.dateTime > ?1")
    List<MovieCinema> fetchAllWithHigherThanSpecificDate(LocalDateTime dateTime);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "Select count(*) from movie_cinema where cinema_id= ?1",nativeQuery = true)
    Integer countByCinemaId(Long cinemaId);
    //Write a native query that returns all movie cinemas by location name
    @Query(value = "SELECT mc.* FROM movie_cinema mc JOIN cinema c " +
            " ON mc.cinema_id = c.id JOIN location l ON c.location_id = l.id " +
            " WHERE l.name = ?1 ",nativeQuery = true)
    List<MovieCinema> retrieveAllByLocationName(String name);
}