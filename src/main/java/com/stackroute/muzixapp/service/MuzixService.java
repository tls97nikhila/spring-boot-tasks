package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixapp.exceptions.TrackNotFoundException;

import java.util.List;

public interface MuzixService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

   public List<Track> deleteById(int id) throws TrackNotFoundException;

   public Track updateById(Track track, int id) throws TrackNotFoundException;

    public  List<Track> getAllTracks() throws TrackNotFoundException;

    public  List<Track> getByName(String name) throws TrackNotFoundException;

    public  Track getTrackById(int id) throws TrackNotFoundException;
}
