package com.comtrade.repository;

import com.comtrade.entity.Vlasnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VlasnikRepository extends JpaRepository<Vlasnik, Long> {
    @Query("select v from Vlasnik v inner join v.ljubimci lj where v.id = :idVlasnik")
    List<Vlasnik> findByLjubimac(Long idVlasnik);
}
