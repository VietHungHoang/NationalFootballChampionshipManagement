package com.vhh.nfcm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ranking extends Team {
    private Integer rank;
    private Integer totalMatch;
    private Integer win;
    private Integer lost;
    private Integer draw;
    private Integer goal;
    private Integer goalAgainst;
    private Integer totalPoint;

    public Ranking(Integer id, String name, Integer totalMatch, Integer win, Integer lost, Integer draw, Integer goal, Integer goalAgainst, Integer totalPoint) {
        super(id, name);
        this.totalMatch = totalMatch;
        this.win = win;
        this.lost = lost;
        this.draw = draw;
        this.goal = goal;
        this.goalAgainst = goalAgainst;
        this.totalPoint = totalPoint;
    }
}
