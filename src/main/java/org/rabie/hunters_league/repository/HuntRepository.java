package org.rabie.hunters_league.repository;

import org.rabie.hunters_league.domain.Hunt;
import org.rabie.hunters_league.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HuntRepository extends JpaRepository<Hunt, UUID> {
    List<Hunt> findBySpecies(Species species);

    @Modifying
    @Query(value = "DELETE FROM hunt WHERE spId IN (SELECT spId FROM hunt WHERE species_id = :speciesId LIMIT :batchSize)", nativeQuery = true)
    int deleteBySpeciesIdBatch(@Param("speciesId") UUID speciesId, @Param("batchSize") int batchSize);



}
