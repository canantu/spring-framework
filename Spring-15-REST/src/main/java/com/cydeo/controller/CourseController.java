package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.entity.Course;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   //@Controller + @ResponseBody
@RequestMapping("/courses/api/v1")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        List<CourseDTO> list = courseService.getCourses();
        return list;
    }
    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByCategory(@PathVariable("name") String category){
        return courseService.getCoursesByCategory(category);
    }

    @PostMapping
    public CourseDTO createCourse( @RequestBody CourseDTO courseDto){
        return courseService.createCourse(courseDto);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable Long courseId, @RequestBody CourseDTO courseDto){
        courseService.updateCourse(courseId, courseDto);
    }

    @DeleteMapping("{id}")
    public void deleteCourseByID(@PathVariable("id") Long courseId){
        courseService.deleteCourseById(courseId);
    }

    @DeleteMapping()
    public void deleteCourses(){
        courseService.deleteCourses();
    }
}
