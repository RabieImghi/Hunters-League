package org.rabie.hunters_league.repository;

import org.rabie.hunters_league.domain.Competition;
import org.rabie.hunters_league.domain.Participation;
import org.rabie.hunters_league.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, UUID> {
    Participation findByUserAndCompetition(User user, Competition competition);

    @Query(value = "SELECT * FROM participation WHERE score = 0 LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Participation> findAllWithLimit(@Param("offset") long offset, @Param("limit") int limit);

    List<Participation> findByUserId(UUID userId, PageRequest pageRequest);

    @Query("SELECT p FROM Participation p ORDER BY p.score DESC")
    List<Participation> getTop3ParticipationOrderByScoreDesc(PageRequest pageRequest);


    @Query(value = """
            WITH RankedParticipations AS (
                SELECT user_id, RANK() OVER (ORDER BY score DESC) AS rank
                FROM participation
                WHERE competition_id = :competitionId
            )
            SELECT rank
            FROM RankedParticipations
            WHERE user_id = :userId
            """, nativeQuery = true)
    Integer getUserRank(@Param("competitionId") UUID competitionId, @Param("userId") UUID userId);

}
