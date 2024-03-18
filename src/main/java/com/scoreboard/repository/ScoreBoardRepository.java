package com.scoreboard.repository;

import com.scoreboard.dto.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreBoardRepository extends JpaRepository<Score, Long> {


}
