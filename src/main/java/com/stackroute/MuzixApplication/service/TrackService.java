package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExistsException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;    //throws exception   //post
    public List<Track> getAllTracks();      //get
    public Track getTrackById(int trackId) throws TrackDoesNotExistsException;  //get
    public Track getTrackByName(String name) throws TrackDoesNotExistsException;    //get
    public Track getTrackByComment(String comment) throws TrackDoesNotExistsException;  //get
    public String deleteTrack(int trackId) throws TrackDoesNotExistsException;  //delete
    public Track updateTrack(Track track) throws TrackAlreadyExistsException;   //put

}
