package com.scoreboard.service;

import com.scoreboard.model.Score;

import java.util.List;

public interface ScoreBoardService {
  List<Score> getScores(int limit, int offset);

  boolean insertScore(Score newScore);
}
