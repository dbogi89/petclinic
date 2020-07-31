package com.comtrade.service;

import com.comtrade.api.dto.LjubimacDtoResponse;
import com.comtrade.api.dto.PosetaDtoRequest;
import com.comtrade.api.dto.PosetaDtoResponse;
import com.comtrade.entity.Ljubimac;
import com.comtrade.entity.Poseta;
import com.comtrade.entity.Veterinar;
import com.comtrade.repository.LjubimacRepository;
import com.comtrade.repository.PosetaRepository;
import com.comtrade.repository.VeterinarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PosetaService {

    private final PosetaRepository posetaRepository;
    private final VeterinarRepository veterinarRepository;
    private final LjubimacRepository ljubimacRepository;
    @Transactional
    public PosetaDtoResponse save(Long idLjubimca, PosetaDtoRequest poseta){
        Ljubimac lj = ljubimacRepository.findById(idLjubimca).orElseThrow(()->new RuntimeException("Ljubimac pobegao"));
        Poseta poseta1 = convertT(poseta);
        poseta1.setLjubimac(lj);
        return convertTOResponse(posetaRepository.save(poseta1));
    }

    private PosetaDtoResponse convertTOResponse(Poseta save) {
    return PosetaDtoResponse.builder()
            .datum_posete(save.getDatum_posete())
            .id(save.getId())
            .opis(save.getOpis())
            .build();
    }

    private Poseta convertT(PosetaDtoRequest poseta) {
        return Poseta.builder()
                .datum_posete(poseta.getDatum_posete())
                .opis(poseta.getOpis())
                .build();
    }

    @Transactional
    public void ljubimacVeterinaccreate(Long idV, HashSet<LjubimacDtoResponse> ljubimci) {
        Veterinar veterinar = veterinarRepository.findById(idV).orElseThrow(()->new RuntimeException("dkdk"));
        Set<Ljubimac>ljubimacs = convertLjubimci(ljubimci);
        ljubimacs.stream().forEach(ljubimac -> {
            Ljubimac lj = ljubimacRepository.findById(ljubimac.getId()).get();
            lj.getVeterinars().add(veterinar);
            ljubimacRepository.save(lj);
            veterinar.getLjubimaci().add(lj);
            veterinarRepository.save(veterinar);
        });

        //veterinar.setLjubimaci(ljubimacs);


    }

    private Set<Ljubimac> convertLjubimci(HashSet<LjubimacDtoResponse> ljubimci) {
        return ljubimci.stream().map(ljubimacDtoResponse -> {
            Ljubimac ljubimac = new Ljubimac();
            ljubimac.setId(ljubimacDtoResponse.getId());
            ljubimac.setIme(ljubimac.getIme());
            return ljubimac;
        }).collect(Collectors.toSet());
    }
}
