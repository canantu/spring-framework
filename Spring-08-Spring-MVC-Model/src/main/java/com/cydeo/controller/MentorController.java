package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @RequestMapping("/list") //localhost:8080/mentor/list
    public String showTable(Model model){

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor(45, "Mike", "Smith", Gender.MALE));
        mentorList.add(new Mentor(65, "Tom", "Hanks", Gender.MALE));
        mentorList.add(new Mentor(25, "Amy", "Brian", Gender.FEMALE));

        model.addAttribute("mentorList", mentorList);

        return "mentor/mentor-list";
    }
}
