package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.NullValuesException;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExistsException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException, NullValuesException;    //post
    public List<Track> getAllTracks();      //get
    public Track getTrackById(int trackId) throws TrackDoesNotExistsException;  //get
    public List<Track> getTrackByName(String name) throws TrackDoesNotExistsException;    //get
    public List<Track> getTrackByComment(String comment) throws TrackDoesNotExistsException;  //get
    public Track deleteTrack(int trackId) throws TrackDoesNotExistsException;  //delete
    public Track updateTrack(Track track) throws TrackDoesNotExistsException;   //put

}
