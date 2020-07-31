package com.comtrade.repository;

import com.comtrade.entity.Poseta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosetaRepository extends JpaRepository<Poseta, Long> {
}
