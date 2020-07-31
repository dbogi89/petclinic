package com.comtrade.api.dto;


import lombok.*;


import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VlasnikDtoReponse {
    private Long id;
    private String imeVlasnika;
    private String prezimeVlasniak;
    private String brojTelefona;
    private String email;
    private Set<LjubimacDtoResponse> ljubimci;

}
