package com.example.lab6.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "directores")

public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "directorId")
    private Integer id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "telefono", length = 9)
    private String telefono;

    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;

}
