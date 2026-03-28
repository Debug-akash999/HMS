package com.example.HMS.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="Following")
public class Follow {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy="follower",cascade=cascadeType.All,fetch = FetchType.LAZY)
    private Set<UserFollow>following;

    @OneToMany(mappedBy="following",cascade=cascadeType.All,fetch=FetchType.LAZY)

    private Set<UserFollow> follower;

}
