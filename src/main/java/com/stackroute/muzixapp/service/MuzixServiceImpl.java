package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MuzixServiceImpl implements MuzixService{
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
    public boolean deleteById(int id) throws TrackNotFoundException {
        Optional<Track> userId = muzixRepository.findById(id);
       if(!userId.isPresent()){
            throw new TrackNotFoundException("Track not found!");
        }
        muzixRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Track> getByName(String name) throws TrackNotFoundException {
        List<Track> userId= muzixRepository.findTitleByName(name);
      
if(!userId.isPresent()){
            throw new TrackNotFoundException("Track not found!");
        }
        return userId;
    }

    @Override
    public Track updateById(Track track, int id) thorws TrackNotFoundException {
        Optional<Track> trackOptional = muzixRepository.findById(id);

        if(!trackOptional.isPresent()){
           throw new TrackNotFoundException("Track not found!");
        }
        

        track.setId(id);
        muzixRepository.save(track);
        return  trackOptional.get();
    }

    @Override
    public List<Track> getAllTracks() throws TrackNotFoundExecption{
        List<Track> list= muzixRepository.findAll();
      if(list.isEmpty()){
        throw new TrackNotFoundException("tracks not found")
      }
    }
  
  

}
