package com.desafios.soccer.repository.repository;

import com.desafios.soccer.repository.model.entity.Clube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Long> {
}
