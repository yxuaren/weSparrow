package com.ren.wesparrow.controller;

import com.ren.wesparrow.dto.ActionRequest;
import com.ren.wesparrow.dto.MatchView;
import com.ren.wesparrow.dto.StartMatchResponse;
import com.ren.wesparrow.service.MatchService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @PostMapping("/start")
    public ResponseEntity<StartMatchResponse> start() {
        MatchView m = service.startMatch();
        return ResponseEntity.ok(new StartMatchResponse(m.matchId, m.playerHealth, m.aiHealth, m.turn, m.status));
    }

    @PostMapping("/action")
    public ResponseEntity<MatchView> action(@Valid @RequestBody ActionRequest req) {
        MatchView m = service.applyAction(req);
        return ResponseEntity.ok(m);
    }
}