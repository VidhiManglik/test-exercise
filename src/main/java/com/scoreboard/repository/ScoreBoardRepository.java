package com.scoreboard.repository;

import com.scoreboard.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreBoardRepository extends JpaRepository<Score, Long> {

    Score findByPlayerId(long playerId);
}
