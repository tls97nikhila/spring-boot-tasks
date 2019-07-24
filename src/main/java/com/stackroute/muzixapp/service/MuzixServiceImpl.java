package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService {
    MuzixRepository muzixRepository;


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
    public void deleteById(int id) {
        muzixRepository.deleteById(id);
    }

    @Override
    public boolean updateById(Track track, int id) {
        Optional<Track> trackOptional = muzixRepository.findById(id);

        if(!trackOptional.isPresent())
        return false;

        track.setId(id);
        muzixRepository.save(track);
        return  true;
    }

    @Override
    public List<Track> getAllTracks() {
        return muzixRepository.findAll();
    }

}
