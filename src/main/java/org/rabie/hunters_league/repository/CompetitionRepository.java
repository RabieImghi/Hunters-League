package org.rabie.hunters_league.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.rabie.hunters_league.domain.Competition;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, UUID> {
    Competition findTopByOrderByDateDesc();
}
