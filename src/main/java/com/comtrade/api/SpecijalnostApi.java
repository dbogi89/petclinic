package com.comtrade.api;

import com.comtrade.entity.Specijalnost;
import com.comtrade.service.SpecijalnostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/specijalnosti")
@RestController
@AllArgsConstructor
public class SpecijalnostApi {
    private SpecijalnostService specijalnostService;

    @PostMapping("")
    public Specijalnost save(@RequestBody Specijalnost specijalnost){
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
