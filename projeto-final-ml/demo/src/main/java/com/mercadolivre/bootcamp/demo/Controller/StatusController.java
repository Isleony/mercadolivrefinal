package com.mercadolivre.bootcamp.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping (path = "/demo/status")
    public String check(){

        return "online";
    }

}
