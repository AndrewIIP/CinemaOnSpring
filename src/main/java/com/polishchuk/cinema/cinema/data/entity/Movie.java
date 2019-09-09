package com.polishchuk.cinema.cinema.data.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@Accessors(chain = true)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String picUrl;

    @OneToMany(fetch = FetchType.LAZY)
    @CollectionTable(name = "sessions", joinColumns = @JoinColumn(name = "movie_id"))
    private List<Session> sessions = new LinkedList<>();

}
