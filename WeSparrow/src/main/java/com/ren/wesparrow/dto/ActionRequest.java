package com.ren.wesparrow.dto;

import jakarta.validation.constraints.NotNull;

public class ActionRequest {
    @NotNull
    public Long matchId;
    @NotNull
    public String action; // END_TURN or PLAY_CARD
    public Integer value; // optional damage value when PLAY_CARD
}