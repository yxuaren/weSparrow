package com.ren.wesparrow.repo;

import com.ren.wesparrow.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}