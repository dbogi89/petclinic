package com.comtrade.api;

import com.comtrade.api.dto.LjubimacDtoResponse;
import com.comtrade.api.dto.VlasnikDtoReponse;
import com.comtrade.api.dto.VlasnikDtoRequest;
import com.comtrade.service.VlasnikServis;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vlasnici")
@AllArgsConstructor
public class VlasnikAPi {

    private final VlasnikServis vlasnikServis;

    @PostMapping("")
    public VlasnikDtoReponse save(@RequestBody  VlasnikDtoRequest dtoRequest){
        return vlasnikServis.save(dtoRequest);
    }
    @GetMapping("/{idVlasnik}")
    public VlasnikDtoReponse findById(@PathVariable Long idVlasnik ){
       return vlasnikServis.findById(idVlasnik);
    }




}
