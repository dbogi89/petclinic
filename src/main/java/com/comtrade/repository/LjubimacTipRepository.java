package com.comtrade.repository;

import com.comtrade.entity.LjubimacTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LjubimacTipRepository extends JpaRepository<LjubimacTip, Long> {
}
