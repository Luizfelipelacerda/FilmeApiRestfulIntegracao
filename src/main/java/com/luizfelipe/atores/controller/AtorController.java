package com.luizfelipe.atores.controller;

import com.luizfelipe.atores.model.DTO.AtorDTO;
import com.luizfelipe.atores.services.AtorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/ator")
@RequiredArgsConstructor
public class AtorController {

    public final AtorService atorService;


    @GetMapping
    public List<AtorDTO> getAtor(){
        return atorService.getAtores();
    }

    @PostMapping
    public void addAtor(@RequestBody AtorDTO atorDto){
        atorService.addAtor(atorDto);
    }
    @PutMapping()
    public void editAtor(@RequestBody AtorDTO atorDTO){
        atorService.editAtor(atorDTO);
    }

    @DeleteMapping(path="{idAtor}")
    public void deleteAtor(@PathVariable("idAtor") Integer idAtor){
        atorService.deleteAtorById(idAtor);
    }

}
