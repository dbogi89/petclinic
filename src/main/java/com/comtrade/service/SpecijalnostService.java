package com.comtrade.service;

import com.comtrade.api.dto.VeterinarDtoRequest;
import com.comtrade.api.dto.VeterinarDtoResponse;
import com.comtrade.entity.Specijalnost;
import com.comtrade.entity.Veterinar;
import com.comtrade.repository.SpecijalnostRepository;
import com.comtrade.repository.VeterinarRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SpecijalnostService {
    private final SpecijalnostRepository specijalnostRepository;
    private final VeterinarRepository veterinarRepository;
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

    @Transactional
    public VeterinarDtoResponse create(Long id, VeterinarDtoRequest veterinarDtoRequest) {
        Specijalnost specijalnost = specijalnostRepository.findById(id).orElseThrow(()->new RuntimeException("ne"));
        Veterinar veterinar = convertTo(veterinarDtoRequest);
        veterinar.setSpecijalnost(specijalnost);
        return convertToResponse(veterinarRepository.save(veterinar));
    }
    private VeterinarDtoResponse convertToResponse(Veterinar veterinar){
       return VeterinarDtoResponse.builder()
                .id(veterinar.getId())
                .ime(veterinar.getIme())
                .build();
    }

    private Veterinar convertTo(VeterinarDtoRequest veterinarDtoRequest) {
        return Veterinar.builder()
                .ime(veterinarDtoRequest.getIme())
                .build();
    }
}
