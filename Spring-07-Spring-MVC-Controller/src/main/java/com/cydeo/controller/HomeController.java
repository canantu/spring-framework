package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  // annotate the class with the @Controller stereotype annotation
public class HomeController {

    @RequestMapping("/home")   // user @RequestMapping to associate the action with an HTTP request path
    public String home(){
        return "home.html";
    }  // return html document name that contains the details we want the browser to display

    @RequestMapping("/welcome")
    public String home2(){
        return "welcome.html";
    }

    @RequestMapping("")
    public String home3(){
        return "welcome.html";
    }
}
