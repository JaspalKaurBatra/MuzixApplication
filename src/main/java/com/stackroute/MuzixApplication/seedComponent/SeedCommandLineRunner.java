package com.stackroute.MuzixApplication.seedComponent;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)   //first this then application one and @Order is for same interface
public class SeedCommandLineRunner implements CommandLineRunner {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void run(String... args) throws Exception {
        trackRepository.save(new Track("song1","comment"));
        trackRepository.save(new Track("song2","comment"));
        trackRepository.save(new Track("song3","comment"));
    }
}
