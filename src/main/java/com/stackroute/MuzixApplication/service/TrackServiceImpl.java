package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.NullValuesException;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExistsException;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException,NullValuesException {

        if(trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        if(track.getName() == null && track.getComment() == null){
            throw new NullValuesException("null values passed");
        }
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();   //returns optional i.e., either null or tracks(No Runtime Exception is thrown on Not Found), so no need to throw an exception
    }

    @Override
    public Track getTrackById(int trackId) throws TrackDoesNotExistsException {

        if(trackRepository.existsById(trackId)){
            return trackRepository.findById(trackId).get();
        }
        else{
            throw new TrackDoesNotExistsException("Track does not exists");
        }

    }


    @Override
    public Optional<Track> getTrackByName(String name){
        return  trackRepository.findOneByName(name);
    }
    @Override
    public Optional<Track> getTrackByComment(String comment){
        return trackRepository.findOneByComment(comment);
    }

    @Override
    public List<Track> getAllTracksByName(String name) throws TrackDoesNotExistsException{
        return  trackRepository.findByName(name);
    }
    @Override
    public List<Track> getAllTracksByComment(String comment) throws TrackDoesNotExistsException{
        return trackRepository.findByComment(comment);
    }

    @Override
    public Track deleteTrack(int trackId) throws TrackDoesNotExistsException {

        if(trackRepository.existsById(trackId)){
            Track deletedTrack = getTrackById(trackId); //storing the track to be deleted in a variable
            trackRepository.deleteById(trackId);
            return deletedTrack;
        }
        else {
            throw new TrackDoesNotExistsException("Track does not exits");
        }

    }

    @Override
    public Track updateTrack(Track track) throws TrackDoesNotExistsException {

        if(trackRepository.existsById(track.getId())) {
            trackRepository.findById(track.getId()).get();
            track.setId(track.getId());
            if(track.getName() != null && track.getName() != "") {
                track.setName(track.getName());
            }
            if(track.getComment() != null && track.getComment() != "" ) {
                track.setComment(track.getComment());
            }
            trackRepository.save(track);
            return track;
        }
        else{
            throw new TrackDoesNotExistsException("Track does not exits");      //
        }

    }



}
