package com.comtrade.service;

import com.comtrade.api.dto.LjubimacDtoResponse;
import com.comtrade.api.dto.VlasnikDtoReponse;
import com.comtrade.api.dto.VlasnikDtoRequest;
import com.comtrade.entity.Ljubimac;
import com.comtrade.entity.Vlasnik;
import com.comtrade.repository.LjubimacRepository;
import com.comtrade.repository.VlasnikRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class VlasnikServis {
    private final VlasnikRepository vlasnikRepository;
    private final LjubimacServis ljubimacServis;
    private final LjubimacRepository ljubimacRepository;

    @Transactional
    public VlasnikDtoReponse save(VlasnikDtoRequest vlasnik){
      return convertToResponse(vlasnikRepository.save(convertTo(vlasnik)));
    }

    private VlasnikDtoReponse convertToResponse(Vlasnik save) {
        return VlasnikDtoReponse.builder().id(save.getId())
                .brojTelefona(save.getBrojTelefona())
                .email(save.getEmail())
                .imeVlasnika(save.getImeVlasnika())
                .prezimeVlasniak(save.getPrezimeVlasniak())
                .build();
    }

    private Vlasnik convertTo(VlasnikDtoRequest vlasnik) {
        return Vlasnik.builder().brojTelefona(vlasnik.getBrojTelefona())
                .imeVlasnika(vlasnik.getImeVlasnika())
                .prezimeVlasniak(vlasnik.getPrezimeVlasniak())
                .email(vlasnik.getEmail())
                .build();
    }

    @Transactional
    public VlasnikDtoReponse findById(Long idVlasnik) {
        List<Ljubimac> vlasnik = ljubimacRepository.findByLjubimac(idVlasnik);//.orElseThrow(()->new RuntimeException("nzm ko si ti"));
        VlasnikDtoReponse vlasnikDtoReponse = new VlasnikDtoReponse();
        vlasnikDtoReponse.setBrojTelefona(vlasnik.get(0).getVlasnik().getBrojTelefona());
        vlasnikDtoReponse.setPrezimeVlasniak(vlasnik.get(0).getVlasnik().getPrezimeVlasniak());
        vlasnikDtoReponse.setImeVlasnika(vlasnik.get(0).getVlasnik().getImeVlasnika());
        vlasnikDtoReponse.setId(vlasnik.get(0).getVlasnik().getId());
        Set<LjubimacDtoResponse>ljubimacDtoResponses = new HashSet<>();
        vlasnik.stream().forEach(ljubimac -> {
            ljubimacDtoResponses.add(ljubimacServis.convertToReponse(ljubimac));
        });
        vlasnikDtoReponse.setLjubimci(ljubimacDtoResponses);
    return vlasnikDtoReponse;
    }
}
