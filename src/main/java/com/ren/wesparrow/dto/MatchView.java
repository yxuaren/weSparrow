package com.ren.wesparrow.dto;

public class MatchView {
    public Long matchId;
    public int playerHealth;
    public int aiHealth;
    public String turn;
    public String status;

    public MatchView(Long matchId, int playerHealth, int aiHealth, String turn, String status) {
        this.matchId = matchId;
        this.playerHealth = playerHealth;
        this.aiHealth = aiHealth;
        this.turn = turn;
        this.status = status;
    }
}