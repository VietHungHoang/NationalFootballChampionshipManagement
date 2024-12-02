package com.vhh.nfcm.service;

import com.vhh.nfcm.entity.Ranking;
import com.vhh.nfcm.iservice.IRankingService;
import com.vhh.nfcm.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RankingService implements IRankingService {
    @Autowired
    TeamRepository teamRepository;
    @Override
    public List<Ranking> getRankingBySeasonId(Integer seasonId) {
        List<Object[]> rankingList = teamRepository.getRankingsForSeason(1L);
        List<Ranking> rankings = new ArrayList<>();
        for (Object[] result : rankingList) {
            Integer teamId = (Integer) result[0];
            String teamName = (String) result[1];
            Integer totalMatches = ((Long) result[2]).intValue();
            Integer totalWins = ((Long) result[3]).intValue();
            Integer totalLosses = ((Long) result[4]).intValue();
            Integer totalDraws = ((Long) result[5]).intValue();
            Integer totalGoalsScored = ((Long) result[6]).intValue();
            Integer totalGoalsConceded = ((Long) result[7]).intValue();
            Integer totalPoints = ((Long) result[8]).intValue();

            // Tạo đối tượng Ranking và thêm vào danh sách
            Ranking ranking = new Ranking(teamId, teamName, totalMatches, totalWins, totalLosses, totalDraws, totalGoalsScored, totalGoalsConceded, totalPoints);
            rankings.add(ranking);
        }
        rankings.sort((o1, o2) -> {
            if(o1.getTotalPoint() == o2.getTotalPoint())
                return -(o1.getGoal() - o1.getGoalAgainst()) + (o2.getGoal() - o2.getGoalAgainst());
            return o2.getTotalPoint() - o1.getTotalPoint();
        });

        for(int i = 0; i < rankings.size(); i++)
            rankings.get(i).setRank(i);
        return rankings;
    }
}
