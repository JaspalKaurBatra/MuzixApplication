package com.stackroute.MuzixApplication.controller;


import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExistsException;
import com.stackroute.MuzixApplication.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/muzix/")
public class TrackController {
    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("save")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            //trackService.saveTrack(track);
            Track savedTrack =trackService.saveTrack(track);
            //responseEntity= new ResponseEntity<Track>(track, HttpStatus.CREATED);
            responseEntity= new ResponseEntity<Track>(savedTrack, HttpStatus.CREATED);
        }
        catch(TrackAlreadyExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @GetMapping("trackById/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable("id") int trackId){
        ResponseEntity responseEntity;
        try{
            Track track=trackService.getTrackById(trackId);  //for parameter-input
            responseEntity= new ResponseEntity<Track>(track, HttpStatus.CREATED); //<type> is for return type
        }
        catch(TrackDoesNotExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("trackByName/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable("name") String name){
        ResponseEntity responseEntity;
        try{
            Track track=trackService.getTrackByName(name);  //for parameter-input
            responseEntity= new ResponseEntity<Track>(track, HttpStatus.CREATED); //<type> is for return type
        }
        catch(TrackDoesNotExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("trackByComment/{comment}")
    public ResponseEntity<?> getTrackByComment(@PathVariable("comment") String comment){
        ResponseEntity responseEntity;
        try{
            Track track = trackService.getTrackByComment(comment);  //for parameter-input
            responseEntity= new ResponseEntity<Track>(track, HttpStatus.CREATED); //<type> is for return type
        }
        catch(TrackDoesNotExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int trackId){
        ResponseEntity responseEntity;
        try{
            trackService.deleteTrack(trackId);  //for parameter-input
            responseEntity= new ResponseEntity<String>("deleted", HttpStatus.CREATED); //<type> is for return type
        }
        catch(TrackDoesNotExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("update")
    public ResponseEntity<?> updateTrack(@RequestBody int trackId){
        ResponseEntity responseEntity;
        try{

            Track track = trackService.updateTrack(trackId);
            responseEntity= new ResponseEntity<Track>(track, HttpStatus.CREATED);
        }
        catch(TrackAlreadyExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        /*catch(TrackDoesNotExistsException ex){
                responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
            }*/
        return responseEntity;
    }


}
