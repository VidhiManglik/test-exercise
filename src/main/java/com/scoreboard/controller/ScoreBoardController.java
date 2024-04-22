package com.scoreboard.controller;

import com.scoreboard.model.Score;
import com.scoreboard.service.ScoreBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

        List<Score> scores = scoreBoardService.getScores(limit, offset);

        return ResponseEntity.ok().body(scores);
    }

    @PostMapping("/scores")
    public ResponseEntity<String> insertScore(@RequestBody Score score) {
        boolean success = scoreBoardService.insertScore(score);

        if (success) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Score inserted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert score");
        }
    }
}
