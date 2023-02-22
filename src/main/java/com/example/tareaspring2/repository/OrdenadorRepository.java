package com.example.tareaspring2.repository;
import com.example.tareaspring2.entities.Ordenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenadorRepository extends JpaRepository<Ordenador,Long> {
}
