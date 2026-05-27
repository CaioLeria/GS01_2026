package com.caio557833.t_space.controller;

import com.caio557833.t_space.dto.ViagemDTO;
import com.caio557833.t_space.service.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

    @Autowired
    private ViagemService service;


    @GetMapping
    public ResponseEntity<List<ViagemDTO>> findAll(){
        List<ViagemDTO> viagemDTOS = service.findAll();
        return ResponseEntity.ok(viagemDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ViagemDTO> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ViagemDTO> create(@RequestBody ViagemDTO dto){
        ViagemDTO created = service.create(dto);
        return ResponseEntity.created(null).body(created) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViagemDTO> update(@RequestBody ViagemDTO dto, @PathVariable Long id){
        return service.update(dto, id);
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
