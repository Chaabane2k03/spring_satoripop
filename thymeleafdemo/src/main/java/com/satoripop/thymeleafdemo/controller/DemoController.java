package com.satoripop.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model) {

        model.addAttribute("theMessage", new java.util.Date());
        return "index"; // name of the template !
    }

}
