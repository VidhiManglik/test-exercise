package com.scoreboard.controller;

import com.scoreboard.dto.Score;
import com.scoreboard.service.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scoreboard")
public class ScoreBoardController {
    private final ScoreBoardService scoreBoardService;

    @Autowired
    public ScoreBoardController(ScoreBoardService scoreBoardService) {
        this.scoreBoardService = scoreBoardService;
    }

    @GetMapping("/scores")
    public ResponseEntity<List<Score>> getScores(
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(defaultValue = "0") int offset) {

        // Fetch scores from the service with limit and offset
        List<Score> scores = scoreBoardService.getScores(limit, offset);

        return ResponseEntity.ok().body(scores);
    }
}
