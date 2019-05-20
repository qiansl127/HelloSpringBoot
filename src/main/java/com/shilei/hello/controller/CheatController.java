package com.shilei.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheatController {

    @RequestMapping("/switch")
    public String doSwitch() {




        return "Switch to CHEAT mode";
    }

}
