package com.comtrade.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VlasnikDtoRequest {
    private String imeVlasnika;
    private String prezimeVlasniak;
    private String brojTelefona;
    private String email;
}
