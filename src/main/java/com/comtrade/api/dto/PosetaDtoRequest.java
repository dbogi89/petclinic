package com.comtrade.api.dto;

import com.comtrade.entity.Ljubimac;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class PosetaDtoRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datum_posete;
    private String opis;
}
