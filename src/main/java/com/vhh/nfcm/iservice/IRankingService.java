package com.vhh.nfcm.iservice;

import com.vhh.nfcm.entity.Ranking;

import java.util.List;

public interface IRankingService {
    List<Ranking> getRankingBySeasonId(Integer seasonId);
}
