package com.scoreboard.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
public class Score implements Serializable {
  private static final long serialVersionUID = 5560221391479816650L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "player_id")
  private Long playerId;

  @Column(name = "player_name")
  private String playerName;

  @Column(name = "player_score")
  private Double playerScore;

  public Score() {}

  public long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(long playerId) {
    this.playerId = playerId;
  }

  public Score(
      Long id,
      String name,
      Long playerId,
      Double score) {
    this.id = id;
    this.playerId = playerId;
    this.playerName = name;
    this.playerScore = score;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPlayerName() {
    return playerName;
  }

  public void setPlayerName(String name) {
    this.playerName = name;
  }

  public Double getPlayerScore() {
    return playerScore;
  }

  public void setPlayerScore(Double score) {
    this.playerScore = score;
  }
}
