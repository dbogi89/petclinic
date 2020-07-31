package com.comtrade.api.dto;

import lombok.*;
import net.bytebuddy.asm.Advice;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VeterinarDtoResponse {
    private Long id;
    private String ime;

}
