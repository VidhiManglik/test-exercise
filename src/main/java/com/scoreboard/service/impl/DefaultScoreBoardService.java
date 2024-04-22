package com.scoreboard.service.impl;

import com.scoreboard.model.Score;
import com.scoreboard.repository.ScoreBoardRepository;
import com.scoreboard.service.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DefaultScoreBoardService implements ScoreBoardService {
    private final ScoreBoardRepository scoreBoardRepository;

    @Autowired
    DefaultScoreBoardService(ScoreBoardRepository scoreBoardRepository) {
        this.scoreBoardRepository = scoreBoardRepository;
    }

    @Override
    public List<Score> getScores(int limit, int offset) {
        return scoreBoardRepository.findAll(
            PageRequest.of(offset / limit, limit, Sort.by(Sort.Direction.DESC, "player_score"))
        ).getContent();
    }

    @Override
    public boolean insertScore(Score score) {

        Score existingScore = scoreBoardRepository.findByPlayerId(score.getPlayerId());

        if (existingScore != null) {
            double updatedScoreValue = existingScore.getPlayerScore() + score.getPlayerScore();
            existingScore.setPlayerScore(updatedScoreValue);
            scoreBoardRepository.save(existingScore);
        } else {
            scoreBoardRepository.save(score);
        }

        return true;
    }
}
