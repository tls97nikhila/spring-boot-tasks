package com.stackroute.muzixapp.service;

import com.stackroute.muzixapp.domain.Track;

import java.util.List;

public interface MuzixService {
    public Track saveTrack(Track track);
   public void deleteById(int id);
   public boolean updateById(Track track, int id);
    public  List<Track> getAllTracks();

    public  List<Track> getByName(String name);
}
