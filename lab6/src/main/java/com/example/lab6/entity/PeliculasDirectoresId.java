package com.example.lab6.entity;

import jakarta.persistence.*;


import java.io.Serializable;

@Embeddable
public class PeliculasDirectoresId implements Serializable {


    @Column(name = "peliculas", nullable = false)
    private Integer peliculaId;

    @Column(name = "directores", nullable = false)
    private Integer directorId;
}
