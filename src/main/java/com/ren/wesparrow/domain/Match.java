package com.ren.wesparrow.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MatchStatus status = MatchStatus.ONGOING;

    @Enumerated(EnumType.STRING)
    private Turn turn = Turn.PLAYER;

    private int playerHealth = 30;
    private int aiHealth = 30;

    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();

    @Version
    private Long version;

    public Long getId() { return id; }
    public MatchStatus getStatus() { return status; }
    public void setStatus(MatchStatus status) { this.status = status; }
    public Turn getTurn() { return turn; }
    public void setTurn(Turn turn) { this.turn = turn; }
    public int getPlayerHealth() { return playerHealth; }
    public void setPlayerHealth(int playerHealth) { this.playerHealth = playerHealth; }
    public int getAiHealth() { return aiHealth; }
    public void setAiHealth(int aiHealth) { this.aiHealth = aiHealth; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }
}