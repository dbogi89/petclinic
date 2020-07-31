package com.comtrade.repository;

import com.comtrade.entity.Veterinar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarRepository extends JpaRepository<Veterinar, Long> {
}
