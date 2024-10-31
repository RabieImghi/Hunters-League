package org.rabie.hunters_league.repository;

import org.rabie.hunters_league.domain.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, UUID> {

}
