package com.vhh.nfcm.controller;

import com.vhh.nfcm.entity.Ranking;
import com.vhh.nfcm.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class RankingController {

    @Autowired
    private RankingService rankingService;

    @GetMapping("/ranking/{id}")
    public String getRankingForSeason(@PathVariable("id") Integer seasonId, Model model) {
        List<Ranking> rankList = rankingService.getRankingBySeasonId(seasonId);
        model.addAttribute("rankings", rankList);
        return "ranking";
    }
}
