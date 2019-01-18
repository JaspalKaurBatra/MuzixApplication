package com.stackroute.MuzixApplication.repository;

import com.stackroute.MuzixApplication.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //This annotation is not compulsory as we are inheriting JpaRepository which already has @Repository annotation
public interface TrackRepository extends JpaRepository<Track,Integer> {
    public Optional<Track> findOneByName(String name);
    public Optional<Track> findOneByComment(String comment);
    public List<Track> findByName(String name);
    public List<Track> findByComment(String comment);
}
