package com.scoreboard.dto;

public class Score {
    private Long id;
    private String playerName;
    private int score;

    // Constructors
    public Score() {
    }

    public Score(Long id, String playerName, int score) {
        this.id = id;
        this.playerName = playerName;
        this.score = score;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
