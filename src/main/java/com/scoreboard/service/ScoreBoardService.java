package com.scoreboard.service;

import com.scoreboard.dto.Score;

import java.util.List;

public interface ScoreBoardService {
  List<Score> getScores(int limit, int offset);
}
