package com.vhh.nfcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(){
        return "index";
    }
//    @GetMapping("/")
//    public String getRankingForSeason() {
//        return "index";  // Trả về trang ranking.html
//    }
}
