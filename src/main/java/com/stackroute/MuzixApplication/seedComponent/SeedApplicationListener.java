package com.stackroute.MuzixApplication.seedComponent;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class SeedApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        trackRepository.save(new Track("song7","comment"));
        trackRepository.save(new Track("song8","comment"));
        trackRepository.save(new Track("song9","comment"));
    }
}
