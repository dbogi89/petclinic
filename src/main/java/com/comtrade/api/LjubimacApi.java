package com.comtrade.api;

import com.comtrade.api.dto.LjubimacDtoResponse;
import com.comtrade.api.dto.LjubimcDtoRequest;
import com.comtrade.entity.LjubimacTip;
import com.comtrade.repository.LjubimacTipRepository;
import com.comtrade.service.LjubimacServis;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PersistenceUnit;
import java.util.List;

@RestController
@RequestMapping("api/v1/ljubimci")
@AllArgsConstructor
public class LjubimacApi {
    private final LjubimacServis ljubimacServis;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody LjubimacTip ljubimacTip){
        try {
            return new ResponseEntity<>(ljubimacServis.save(ljubimacTip), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Problem kod upisa", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/{idTip}")
    public LjubimacDtoResponse saveLjubimc(@PathVariable Long idTip, @RequestBody LjubimcDtoRequest lj){
        return ljubimacServis.saveLjubimac(idTip, lj);
    }
    @GetMapping("")
    public List<LjubimacDtoResponse> findAll(){
        return ljubimacServis.findAll();
    }
    @GetMapping("/{idLjubimac}")
    public LjubimacDtoResponse findById(@PathVariable Long idLjubimac){
        return ljubimacServis.findById(idLjubimac);
    }
    @DeleteMapping("/{idLjubimac}")
    public ResponseEntity<?>delete(@PathVariable Long idLjubimac){
        try {
            ljubimacServis.delete(idLjubimac);
            return new ResponseEntity<>("Ljubimac obrisan", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Ljubimac nije obrisan", HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{idLjubimac}/{idVlasnik}")
    public LjubimacDtoResponse update(@PathVariable Long idLjubimac,@PathVariable Long idVlasnik){
            return ljubimacServis.update(idLjubimac, idVlasnik);
    }




}

