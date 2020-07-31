package com.comtrade.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Poseta extends BazniEntitet{
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datum_posete;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ljubimac ljubimac;
    private String opis;
}
