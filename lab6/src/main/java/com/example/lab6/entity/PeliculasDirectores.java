package com.example.lab6.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "peliculas_directores")
public class PeliculasDirectores {

    @EmbeddedId
    private PeliculasDirectoresId Id;

    @MapsId("peliculaId")
    @ManyToOne
    @JoinColumn(name ="peliculas")
    private Pelicula peliculaID;

    @MapsId("directorId")
    @ManyToOne
    @JoinColumn(name ="directores")
    private Director directorID;

}
