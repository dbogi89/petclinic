package com.comtrade.repository;

import com.comtrade.entity.Specijalnost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecijalnostRepository extends JpaRepository<Specijalnost, Long> {
}
