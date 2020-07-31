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
public class Veterinar extends BazniEntitet {
    private String ime;
    @ManyToOne(fetch = FetchType.LAZY)
    private Specijalnost specijalnost;//na ovom da uradite vezu many to many
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "veterinar_ljubimac", joinColumns = @JoinColumn(name = "id_veterinar"),
            inverseJoinColumns = @JoinColumn(name = "id_ljubimac"))
    private Set<Ljubimac> ljubimaci = new HashSet<>();
}
