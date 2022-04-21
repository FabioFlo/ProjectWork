package com.g3.projectwork.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {
    // mappa localhost:8080/test
    // esegui il metodo test()
    //@ResponseBody indica semplicemnte che restituirà una stringa.
    //                In modo analogo a syso

    @GetMapping("/home")
    @ResponseBody
    public String home() {
        return "Home.html";
    }
}
