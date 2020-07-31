package com.comtrade.service;

import com.comtrade.api.dto.LjubimacDtoResponse;
import com.comtrade.api.dto.LjubimcDtoRequest;
import com.comtrade.entity.Ljubimac;
import com.comtrade.entity.LjubimacTip;
import com.comtrade.entity.Vlasnik;
import com.comtrade.repository.LjubimacRepository;
import com.comtrade.repository.LjubimacTipRepository;
import com.comtrade.repository.VlasnikRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LjubimacServis {
    private final LjubimacTipRepository ljubimacTip;
    private final LjubimacRepository ljubimacRepository;
    private final VlasnikRepository vlasnikRepository;


    @Transactional
    public LjubimacTip save(LjubimacTip ljt) {
        return ljubimacTip.save(ljt);

    }
    @Transactional
    public LjubimacDtoResponse saveLjubimac(Long idTip, LjubimcDtoRequest lj) {
        LjubimacTip tip  = ljubimacTip.findById(idTip)
                .orElseThrow(()-> new RuntimeException("Tip ne postoji"));
        Ljubimac ljubimac = convertTo(lj);
        ljubimac.setLjubimacTip(tip);
        return convertToReponse(ljubimacRepository.save(ljubimac));
    }

    public LjubimacDtoResponse convertToReponse(Ljubimac save) {
        return LjubimacDtoResponse.builder().id(save.getId())
                .naziv(save.getIme()).build();
    }

    private Ljubimac convertTo(LjubimcDtoRequest lj) {
        Ljubimac ljubimac = new Ljubimac();
        ljubimac.setIme(lj.getNaziv());
        return ljubimac;
    }

    public List<LjubimacDtoResponse> findAll() {
       List<Ljubimac>ljubimci = ljubimacRepository.findAll();
       return ljubimci.stream().
               map(lj -> convertToReponse(lj) )
               .collect(Collectors.toList());

    }

    public LjubimacDtoResponse findById(Long idLjubimac) {
        Ljubimac ljubimac = ljubimacRepository.findById(idLjubimac).orElseThrow(()->new RuntimeException("Ljubimac ne psotoji"));
        return convertToReponse(ljubimac);
    }
    @Transactional
    public void delete(Long idLjubimac) {
        Ljubimac ljubimac = ljubimacRepository.findById(idLjubimac).orElseThrow(()-> new RuntimeException(":jubimac ne postoji"));
        ljubimacRepository.delete(ljubimac);

    }

    @Transactional
    public LjubimacDtoResponse update(Long idLjubimac, Long idVlasnik) {
        Ljubimac ljubimac = ljubimacRepository.findById(idLjubimac).orElseThrow(()->new RuntimeException("Ljubimac ne postoji"));
        Vlasnik vlasnik = vlasnikRepository.findById(idVlasnik).orElseThrow(()->new RuntimeException("Vlansik je zaspao!!!!"));
        ljubimac.setVlasnik(vlasnik);
        return convertToReponse(ljubimac);
    }
}
