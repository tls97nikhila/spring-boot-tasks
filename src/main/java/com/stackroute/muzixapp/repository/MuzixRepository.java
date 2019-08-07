package com.stackroute.muzixapp.repository;

import com.stackroute.muzixapp.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuzixRepository extends JpaRepository<Track,Integer> {

    @Query(value = "SELECT * FROM track where track_name = ?",
    nativeQuery = true)
    List<Track> findTitleByName(String name);
}
