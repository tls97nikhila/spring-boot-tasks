package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService  {

    @Value("${track.1.trackName:default}")
    String name1;
    @Value("${track.1.trackComments:default}")
    String comments1;
    @Value("${track.2.trackName:default}")
    String name2;
    @Value("${track.2.trackComments:default}")
    String comments2;

     private  MuzixRepository muzixRepository;


    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository){
        this.muzixRepository=muzixRepository;
    }


    @Override
    public Track saveTrack(Track track)  throws TrackAlreadyExistsException {
        if(muzixRepository.existsById(track.getId())){
            throw new TrackAlreadyExistsException("User already exists!");
        }
           Track savedTrack = muzixRepository.save(track);
        if(savedTrack == null) {
            throw new TrackAlreadyExistsException("User already exists!");
        }
        return savedTrack;
    }

    @Override
    public List<Track> deleteById(int id) throws TrackNotFoundException {
        Optional<Track> tracks = muzixRepository.findById(id);
        if(tracks.isEmpty()){
            throw new TrackNotFoundException("Track not found!");
        }
        muzixRepository.deleteById(id);
        return  muzixRepository.findAll();
    }

    @Override
    public Track getTrackById(int id) throws TrackNotFoundException {
        Optional<Track> user_id = muzixRepository.findById(id);
        if (!user_id.isPresent())
            throw new TrackNotFoundException("Record not found");
        return user_id.get();
    }

    @Override
    public List<Track> getByName(String name) throws TrackNotFoundException {
        List<Track> userId= muzixRepository.findTitleByName(name);
        if (userId.isEmpty())
            throw new TrackNotFoundException("Record not found");
        return userId;
    }

    @Override
    public Track updateById(Track track, int id) throws TrackNotFoundException{
        Optional<Track> trackOptional = muzixRepository.findById(id);

        if(!trackOptional.isPresent())
            track.setId(id);
        muzixRepository.save(track);
        MuzixService muzixService=null;

        return muzixService.getTrackById(id);
    }

    @Override
    public List<Track> getAllTracks() {
        return muzixRepository.findAll();
    }



}
