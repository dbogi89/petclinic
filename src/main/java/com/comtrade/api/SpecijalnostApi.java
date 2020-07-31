package com.comtrade.api;

import com.comtrade.entity.Specijalnost;
import com.comtrade.service.SpecijalnostService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("api/v1/specijalnosti")
@RestController
@AllArgsConstructor
public class SpecijalnostApi {
    private SpecijalnostService specijalnostService;
    private  final Logger logger = LoggerFactory.getLogger(SpecijalnostApi.class);
    @GetMapping("/nzm")
    public List<String>getALl(){
        return Arrays.asList("Dejan","Milos","Ivana","Nikola");
    }

    @PostMapping("")
    public Specijalnost save(@RequestBody Specijalnost specijalnost){
        logger.info("Vrednost koja je stigla je "+specijalnost.getNazivSpecijalnosti());
        return specijalnostService.save(specijalnost);
    }
    @GetMapping("")
    public List<Specijalnost> findAll(){
        return specijalnostService.findAll();
    }
    @GetMapping("/{id}")
    public Specijalnost findById(@PathVariable Long id){
       return specijalnostService.findById(id);
    }
    @PutMapping("")
    public Specijalnost update(@RequestBody Specijalnost specijalnost){
        return specijalnostService.update(specijalnost);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        try {
            return new ResponseEntity<>("obrisana specijanlost", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("podatak nije obrisan", HttpStatus.BAD_REQUEST);
        }

    }

}
