package com.stackroute.MuzixApplication.seedComponent;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SeedApplicationRunner implements ApplicationRunner {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        trackRepository.save(new Track("song4","comment"));
        trackRepository.save(new Track("song5","comment"));
        trackRepository.save(new Track("song6","comment"));
    }
}
