package com.comtrade.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vlasnik extends BazniEntitet {
    private String imeVlasnika;
    private String prezimeVlasniak;
    private String brojTelefona;
    private String email;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "vlasnik", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ljubimac> ljubimci = new HashSet<>();
}
