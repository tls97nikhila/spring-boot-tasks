package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {
 private   MuzixRepository muzixRepository;


    @Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository){
        this.muzixRepository=muzixRepository;
    }
    @Override
    public Track saveTrack(Track track)  {

           Track savedTrack = muzixRepository.save(track);

        return savedTrack;
    }

       @Override
    public List<Track> deleteById(int id)  {
        Optional<Track> tracks = muzixRepository.findById(id);
     
        muzixRepository.deleteById(id);
        return  muzixRepository.findAll();
    }


    @Override
    public Track updateById(Track track, int id) {
        Optional<Track> trackOptional = muzixRepository.findById(id);

        if(!trackOptional.isPresent())
        return trackOptional.get();

        track.setId(id);
        muzixRepository.save(track);
        return  trackOptional.get();
    }

    @Override
    public List<Track> getAllTracks() {
        return muzixRepository.findAll();
    }

}
