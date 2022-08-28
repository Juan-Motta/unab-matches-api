package com.matches.repositories;

import com.matches.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(nativeQuery = true, value="SELECT * FROM teams WHERE id=:id")
    public Team findTeamById(Long id);
    @Query(nativeQuery = true, value="SELECT * FROM teams WHERE name ilike '%:name%'")
    public Team findByName(@Param("name") String name);

    @Query(nativeQuery = true, value="SELECT * FROM teams WHERE abbreviation ilike '%:abbreviation%'")
    public Team findByAbbreviation(@Param("abbreviation") String abbreviation);
}
