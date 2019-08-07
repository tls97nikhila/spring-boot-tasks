package com.stackroute.muzixapp.contoller;

import com.stackroute.muzixapp.domain.Track;
import com.stackroute.muzixapp.service.MuzixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class TrackController {
  private  MuzixService muzixService;

    public TrackController(MuzixService muzixService){
        this.muzixService=muzixService;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try {
            muzixService.saveTrack(track);
            responseEntity= new ResponseEntity("Successfully created", HttpStatus.CREATED);

        }catch (Exception ex){
            responseEntity= new ResponseEntity<String>(ex.getMessage() , HttpStatus.CONFLICT );

        }
        return responseEntity;
    }

    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int id) {
        muzixService.deleteById(id);
        return new ResponseEntity<List<Track>>(muzixService.getAllTracks(), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateTrack(@RequestBody Track track, @PathVariable int id){
      if(  muzixService.updateById(track,id)){
          return ResponseEntity.notFound().build();
      }
              return ResponseEntity.noContent().build();
   }

    }
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(muzixService.getAllTracks(),HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public  ResponseEntity<List<Track>> getByName(@PathVariable String name){
        List<Track> tracks= muzixService.getByName(name);
        return new ResponseEntity<List<Track>>(tracks,HttpStatus.OK);
    }
}
