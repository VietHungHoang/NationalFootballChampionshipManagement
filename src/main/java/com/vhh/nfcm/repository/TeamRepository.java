package com.vhh.nfcm.repository;

import com.vhh.nfcm.entity.Ranking;
import com.vhh.nfcm.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeamRepository extends JdpaRepository<Team, Long> {

    @Query("SELECT " +
            "tp.team.id AS teamId, " +
            "t.name AS teamName, " +
            "COUNT(m.id) AS totalMatches, " +
            "SUM(CASE WHEN tp.result > tp2.result THEN 1 ELSE 0 END) AS totalWins, " +
            "SUM(CASE WHEN tp.result < tp2.result THEN 1 ELSE 0 END) AS totalLosses, " +
            "SUM(CASE WHEN tp.result = tp2.result THEN 1 ELSE 0 END) AS totalDraws, " +
            "SUM(tp.result) AS totalGoalsScored, " +
            "SUM(tp2.result) AS totalGoalsConceded, " +
            "(3 * SUM(CASE WHEN tp.result > tp2.result THEN 1 ELSE 0 END) + " +
            "SUM(CASE WHEN tp.result = tp2.result THEN 1 ELSE 0 END)) AS totalPoints " +
            "FROM Match m " +
            "JOIN m.round r " +
            "JOIN r.season s " +
            "JOIN m.teamParticipations tp " +
            "JOIN m.teamParticipations tp2 " +
            "JOIN tp.team t " +
            "WHERE s.id = :seasonId " +
            "AND tp.team.id != tp2.team.id " +
            "GROUP BY tp.team.id, t.name "
            )
    List<Object[]> getRankingsForSeason(@Param("seasonId") Long seasonId);


}
