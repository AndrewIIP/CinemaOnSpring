package com.polishchuk.cinema.cinema.data.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "sessions")
@Data
@Accessors(chain = true)
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Time time;
    private String timeHoursMins;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "day_id")
    private Day day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "session")
    @CollectionTable(name = "tickets", joinColumns = @JoinColumn(name = "session_id"))
    private List<Ticket> ticketList = new LinkedList<>();

}
