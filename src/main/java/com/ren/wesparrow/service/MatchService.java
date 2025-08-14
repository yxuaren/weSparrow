package com.ren.wesparrow.service;

import com.ren.wesparrow.domain.Match;
import com.ren.wesparrow.domain.MatchStatus;
import com.ren.wesparrow.domain.Turn;
import com.ren.wesparrow.dto.ActionRequest;
import com.ren.wesparrow.dto.MatchView;
import com.ren.wesparrow.repo.MatchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class MatchService {

    private final MatchRepository repo;
    private final Random rng = new Random();

    public MatchService(MatchRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public MatchView startMatch() {
        Match m = new Match();
        m.setPlayerHealth(30);
        m.setAiHealth(30);
        m.setTurn(Turn.PLAYER);
        m.setStatus(MatchStatus.ONGOING);
        m.setCreatedAt(Instant.now());
        m.setUpdatedAt(Instant.now());
        m = repo.save(m);
        return toView(m);
    }

    @Transactional
    public MatchView applyAction(ActionRequest req) {
        Match m = repo.findById(req.matchId).orElseThrow(() -> new NoSuchElementException("Match not found"));
        if (m.getStatus() == MatchStatus.FINISHED) return toView(m);

        // Player action
        if ("PLAY_CARD".equalsIgnoreCase(req.action) && m.getTurn() == Turn.PLAYER) {
            int dmg = (req.value != null ? req.value : 3);
            m.setAiHealth(Math.max(0, m.getAiHealth() - dmg));
            m.setTurn(Turn.AI);
        } else if ("END_TURN".equalsIgnoreCase(req.action) && m.getTurn() == Turn.PLAYER) {
            m.setTurn(Turn.AI);
        }

        checkFinished(m);
        if (m.getStatus() == MatchStatus.FINISHED) {
            m.setUpdatedAt(Instant.now());
            repo.save(m);
            return toView(m);
        }

        // AI action (very simple)
        if (m.getTurn() == Turn.AI && m.getStatus() == MatchStatus.ONGOING) {
            int aiDamage = 1 + rng.nextInt(5); // 1..5
            m.setPlayerHealth(Math.max(0, m.getPlayerHealth() - aiDamage));
            m.setTurn(Turn.PLAYER);
        }

        checkFinished(m);
        m.setUpdatedAt(Instant.now());
        m = repo.save(m);
        return toView(m);
    }

    private void checkFinished(Match m) {
        if (m.getPlayerHealth() <= 0 || m.getAiHealth() <= 0) {
            m.setStatus(MatchStatus.FINISHED);
        }
    }

    private MatchView toView(Match m) {
        return new MatchView(
                m.getId(),
                m.getPlayerHealth(),
                m.getAiHealth(),
                m.getTurn().name(),
                m.getStatus().name()
        );
    }
}