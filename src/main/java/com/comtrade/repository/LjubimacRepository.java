package com.comtrade.repository;

import com.comtrade.entity.Ljubimac;
import com.comtrade.entity.Vlasnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LjubimacRepository extends JpaRepository<Ljubimac, Long> {
    @Query("select lj from Ljubimac lj inner join lj.vlasnik v where v.id = :idVlasnik")
    List<Ljubimac> findByLjubimac(Long idVlasnik);
    @Query(value = "INSERT INTO veterinar_ljubimac(id_veterinar, id_ljubimac) VALUES (?1,?2) ", nativeQuery = true)
    void insert(Long id, Long id1);
}
