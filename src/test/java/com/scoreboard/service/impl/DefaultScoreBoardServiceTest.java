package com.scoreboard.service.impl;

import com.scoreboard.dto.Score;
import com.scoreboard.repository.ScoreBoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class DefaultScoreBoardServiceTest {

    @Autowired
    DefaultScoreBoardService scoreBoardService;
    ScoreBoardRepository scoreBoardRepository;

    @Test
    @DisplayName("")
    void fetchedCorrectly() {
      List<Score> mockScores = new ArrayList<>();
      mockScores.add(new Score(1L, "Player1", 100));
      mockScores.add(new Score(2L, "Player2", 90));
      mockScores.add(new Score(3L, "Player3", 80));

      Mockito.when(scoreBoardRepository.findAll(
              PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "score"))
      )).thenReturn(new PageImpl<>(mockScores));

      DefaultScoreBoardService scoreBoardService = new DefaultScoreBoardService(scoreBoardRepository);
      List<Score> fetchedScores = scoreBoardService.getScores(10, 0);
      assertEquals(3, fetchedScores.size()); // Assuming mock data has 3 scores
      assertEquals("Player1", fetchedScores.get(0).getPlayerName());
      assertEquals(100, fetchedScores.get(0).getScore());
    }
}
