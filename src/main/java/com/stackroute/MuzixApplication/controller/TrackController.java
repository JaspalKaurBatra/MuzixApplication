package com.stackroute.MuzixApplication.controller;


import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.NullValuesException;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExistsException;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExistsException;
import com.stackroute.MuzixApplication.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//basically this is a handler??? doing the mapping?
@RestController
@RequestMapping(value="/api/muzix/")
@Api(description = "Tracks Information")
public class TrackController {


    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @ApiOperation(value = "Add the Tracks")
    @PostMapping("save")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException,NullValuesException{
        ResponseEntity responseEntity;
        Track savedTrack =trackService.saveTrack(track);
        responseEntity= new ResponseEntity<Track>(savedTrack, HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiResponses(                                  //dont use this
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful fetching")
            }
    )
    @ApiOperation(value = "Fetch all the Tracks")
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch the Tracks based on ID")
    @GetMapping("trackById/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable("id") int trackId) throws TrackDoesNotExistsException{
        ResponseEntity responseEntity;
        Track track=trackService.getTrackById(trackId);
        responseEntity= new ResponseEntity<Track>(track, HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiOperation(value = "Fetch the Track based on Name - 1 result")
    @GetMapping("trackByName/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable("name") String name){
        ResponseEntity responseEntity;
        Optional<Track> track=trackService.getTrackByName(name);
        responseEntity= new ResponseEntity<Optional<Track>>(track, HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiOperation(value = "Fetch the Track based on Comment - 1 result")
    @GetMapping("trackByComment/{comment}")
    public ResponseEntity<?> getTrackByComment(@PathVariable("comment") String comment){
        ResponseEntity responseEntity;
        Optional<Track> track = trackService.getTrackByComment(comment);
        responseEntity= new ResponseEntity<Optional<Track>>(track, HttpStatus.CREATED);
        return responseEntity;
    }


    @ApiOperation(value = "Fetch all the Tracks based on Name")
    @GetMapping("tracksByName/{name}")
    public ResponseEntity<?> getTracksByName(@PathVariable("name") String name) throws TrackDoesNotExistsException{
        ResponseEntity responseEntity;
        List<Track> track=trackService.getAllTracksByName(name);  //for parameter-input
        responseEntity= new ResponseEntity<List<Track>>(track, HttpStatus.CREATED); //<type> is for return type
        return responseEntity;
    }

    @ApiOperation(value = "Fetch all the Tracks based on Comment")
    @GetMapping("tracksByComment/{comment}")
    public ResponseEntity<?> getTracksByComment(@PathVariable("comment") String comment) throws TrackDoesNotExistsException{
        ResponseEntity responseEntity;
        List<Track> track = trackService.getAllTracksByComment(comment);  //for parameter-input
        responseEntity= new ResponseEntity<List<Track>>(track, HttpStatus.CREATED); //<type> is for return type
        return responseEntity;
    }

    @ApiOperation(value = "Delete the Tracks based on ID")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int trackId) throws TrackDoesNotExistsException{
        ResponseEntity responseEntity;
        Track track = trackService.deleteTrack(trackId);
        responseEntity= new ResponseEntity<Track>(track, HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiOperation(value = "Update the track")
    @PutMapping("update")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackDoesNotExistsException{
        ResponseEntity responseEntity;
        Track updatedTrack = trackService.updateTrack(track);
        responseEntity= new ResponseEntity<Track>(updatedTrack, HttpStatus.CREATED);
        return responseEntity;
    }


}
