package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExistsException;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {

        if(trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException("user already exists");
        }
        Track savedTrack = trackRepository.save(track);
        if(savedTrack == null){
            throw new TrackAlreadyExistsException("user already exists");    //add some other exception
        }
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int trackId) throws TrackDoesNotExistsException {
        return trackRepository.findById(trackId).get();
    }

    @Override
    public Track getTrackByName(String name) throws TrackDoesNotExistsException {
        return trackRepository.findByName(name);
    }

    @Override
    public Track getTrackByComment(String comment) throws TrackDoesNotExistsException {
        return trackRepository.findByComment(comment);
    }

    @Override
    public String deleteTrack(int trackId) throws TrackDoesNotExistsException {
        trackRepository.deleteById(trackId);    //add exceptions later
        return "Deleted";
    }
/*
    @Override
    public Track updateTrack(int trackId) throws TrackAlreadyExistsException {
        Track track = trackRepository.findById(trackId).get();

        return track;
    }*/

    @Override
    public Track updateTrack(Track track) throws TrackAlreadyExistsException {

        trackRepository.findById(track.getId()).get();
        track.setId(track.getId());
        track.setName(track.getName());
        track.setComment(track.getComment());
        trackRepository.save(track);

        return track;
    }



}
