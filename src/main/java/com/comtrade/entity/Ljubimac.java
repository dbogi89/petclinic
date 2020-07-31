package com.comtrade.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ljubimac extends BazniEntitet {
    private String ime;
    @ManyToOne(fetch = FetchType.LAZY)
    private LjubimacTip ljubimacTip;
    @ManyToOne(fetch = FetchType.LAZY)
    private Vlasnik vlasnik;
    @OneToMany(mappedBy = "ljubimac", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Poseta> posete = new HashSet<>();



}
