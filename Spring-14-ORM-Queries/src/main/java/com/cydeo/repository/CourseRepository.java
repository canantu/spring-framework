package com.cydeo.repository;

import com.cydeo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    // find all courses by category
    List<Course> findByCategory(String category);

    // find all courses by category and order entities by nam
    List<Course> findByCategoryOrderByName(String category);

    // check if a course exist with the given name
    boolean existsByName(String name);

    // returns the counts of courses for the provided category
    List<Course> countByCategory(String category);

    // find all courses starts with provided course name
    List<Course> findByNameStartsWith(String name);

    @Query("select c from Course c where c.category = :category and c.rating > :rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);


}
