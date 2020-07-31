package com.comtrade.api;

import com.comtrade.api.dto.LjubimacDtoResponse;
import com.comtrade.api.dto.PosetaDtoRequest;
import com.comtrade.api.dto.PosetaDtoResponse;
import com.comtrade.service.PosetaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RequestMapping("/api/v1/posete")
@RestController
@AllArgsConstructor
public class PosetaApi {
    private final PosetaService posetaService;

    @PostMapping("/{id}")
    public PosetaDtoResponse save(@PathVariable Long id, @RequestBody PosetaDtoRequest po){
        return posetaService.save(id, po);
    }
    @PostMapping("/ljubimac/{idV}")
    public void ljubimacVeterinaccreate(@PathVariable Long idV, @RequestBody HashSet<LjubimacDtoResponse> ljubimci){
        posetaService.ljubimacVeterinaccreate(idV, ljubimci);
    }


}
