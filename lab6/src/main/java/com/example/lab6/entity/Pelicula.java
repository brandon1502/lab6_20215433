package com.example.lab6.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import jakarta.validation.constraints.*;
@Getter
@Setter
@Entity
@Table(name = "peliculas")

public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "peliculaId")
    private Integer id;



    @Column(name = "titulo")
    @Size(min= 3,max = 100,message = "Solo se aceptan títulos de entre 3 y 100 caracteres")
    private String titulo;


    @Column(name = "fechaEstreno")
    @PastOrPresent(message = "La fecha de estreno debe ser pasada o presente")
    private Date fechaEstreno;

    @Column(name = "duracionMinutos")
    @Positive
    private String duracionMinutos;

}
