package com.caio557833.t_space.controller;

import com.caio557833.t_space.dto.PassageiroDTO;
import com.caio557833.t_space.service.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passageiro")
public class PassageiroController {

    @Autowired
    private PassageiroService service;


    @GetMapping
    public ResponseEntity<List<PassageiroDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassageiroDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PassageiroDTO> create(@RequestBody PassageiroDTO dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassageiroDTO> update(@RequestBody PassageiroDTO dto, @PathVariable Long id){
        return ResponseEntity.ok(service.update(dto, id));
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
