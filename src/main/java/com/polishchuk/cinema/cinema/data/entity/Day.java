package com.polishchuk.cinema.cinema.data.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "days")
@Data
@Accessors(chain = true)
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String shortName;

    @OneToMany(fetch = FetchType.LAZY)
    @CollectionTable(name = "sessions", joinColumns = @JoinColumn(name = "day_id"))
    private List<Session> sessions = new LinkedList<>();

}
