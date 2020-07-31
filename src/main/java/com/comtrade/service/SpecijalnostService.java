package com.comtrade.service;

import com.comtrade.entity.Specijalnost;
import com.comtrade.repository.SpecijalnostRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SpecijalnostService {
    private final SpecijalnostRepository specijalnostRepository;
    public Specijalnost save(Specijalnost specijalnost){
        return specijalnostRepository.save(specijalnost);
    }

    public List<Specijalnost> findAll() {
        return specijalnostRepository.findAll();
    }

    public Specijalnost findById(Long id) {
        return specijalnostRepository.findById(id).orElseThrow(()->new RuntimeException("nisam ucio skolu"));
    }

    @Transactional
    public Specijalnost update(Specijalnost specijalnost) {
        return specijalnostRepository.save(specijalnost);
    }
}
