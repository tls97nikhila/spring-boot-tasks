package com.stackroute.muzixapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
  private    int id;
   private String trackName;
   private String trackComments;
}

