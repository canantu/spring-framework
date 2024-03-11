package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/car")
public class CarController {

    @RequestMapping("/info")  //localhost:8080/car/info?make=Honda&year=2020
    public String carInfo(@RequestParam(value="make", required = false, defaultValue = "Tesla") String make, @RequestParam(value = "year", required = false, defaultValue = "2024") Integer year, Model model){    // @RequestParam provides to define query parameter

        model.addAttribute("make", make);  // send data to view
        model.addAttribute("year", year);  // send data to view
        System.out.println(make);  // print data that is provided by browser

        return "/car/car-info";
    }

    @RequestMapping("/info/{make}/{year}")   //localhost:8080/car/info/Honda
    public String getCarInfo(@PathVariable String make, @PathVariable Integer year, Model model){

        model.addAttribute("make", make);  // send data to view
        model.addAttribute("year", year);  // send data to view

        return "/car/car-info";
    }
}
//path variables are not optional, because we are changing the end point