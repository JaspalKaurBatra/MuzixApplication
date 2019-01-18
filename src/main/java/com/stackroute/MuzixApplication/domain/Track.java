package com.stackroute.MuzixApplication.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ApiModelProperty(notes = "Name of the Track")
    @Column
    private String name;

    @ApiModelProperty(notes = "Comment for the track")
    @Column
    private String comment;

    public Track(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }
}
