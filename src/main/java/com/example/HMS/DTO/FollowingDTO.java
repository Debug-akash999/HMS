package com.example.HMS.DTO;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FollowingDTO {


    private Long id;
    private String name;

    public FollowingDTO(Long id, String name){

        this.id=id;
        this.name=name;


    }

}
