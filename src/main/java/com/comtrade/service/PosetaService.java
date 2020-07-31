package com.comtrade.service;

import com.comtrade.api.dto.PosetaDtoRequest;
import com.comtrade.api.dto.PosetaDtoResponse;
import com.comtrade.entity.Ljubimac;
import com.comtrade.entity.Poseta;
import com.comtrade.repository.LjubimacRepository;
import com.comtrade.repository.PosetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PosetaService {
    private final PosetaRepository posetaRepository;
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
}
