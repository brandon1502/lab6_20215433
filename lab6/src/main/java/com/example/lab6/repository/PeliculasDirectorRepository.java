package com.example.lab6.repository;

import com.example.lab6.entity.PeliculasDirectores;
import com.example.lab6.entity.PeliculasDirectoresId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasDirectorRepository extends JpaRepository<PeliculasDirectores, PeliculasDirectoresId> {
}
