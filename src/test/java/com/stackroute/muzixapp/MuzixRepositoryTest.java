package com.stackroute.muzixapp;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.repository.MuzixRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MuzixRepositoryTest {

    @Autowired
    MuzixRepository repository;
    Track track;
    @Before
    public void setUp() {
        track = new Track(1, "Name", "Comments");
    }

    @After
    public void tearDown(){

        repository.deleteAll();
    }

    @Test
    public void testSaveTrack(){
        repository.save(track);
        Track fetchTrack = repository.findById(track.getId()).get();
        Assert.assertEquals(1,fetchTrack.getId());

    }

    @Test
    public void testSaveTrackFailure(){
        Track track1 = new Track(11, "Name", "Comments");
        repository.save(track);
        Track fetchTrack = repository.findById(track.getId()).get();
        Assert.assertNotSame(track1,track);
    }

    @Test
    public void testGetAllTracks(){
       Track track1 = new Track(1, "Name", "Comments");

         Track track2 = new Track(2, "Name2", "Comments2");
            repository.save(track1);
            repository.save(track2);
        List<Track> list = repository.findAll();
        Assert.assertEquals("Name",list.get(0).getTrackName());
    }


    @Test
    public void testUpdateComment(){
        Track track1 = new Track(1, "Name", "Comments");

        repository.save(track1);
        track1.setTrackComments("good");
        repository.save(track1);
        String comment = (repository.findById(1).get()).getTrackComments();
        Assert.assertEquals("good", comment);
    }
}
