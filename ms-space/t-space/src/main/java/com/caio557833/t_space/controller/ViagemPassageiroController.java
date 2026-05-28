package com.caio557833.t_space.controller;

import com.caio557833.t_space.dto.ViagemPassageiroDTO;
import com.caio557833.t_space.service.ViagemPassageiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/viagem-passageiro")
public class ViagemPassageiroController {

    @Autowired
    private ViagemPassageiroService service;


    @GetMapping
    public ResponseEntity<List<ViagemPassageiroDTO>> findAll() {

        return ResponseEntity.ok(
                service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ViagemPassageiroDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.findById(id));
    }


    @PostMapping
    public ResponseEntity<ViagemPassageiroDTO> create(
            @Valid @RequestBody ViagemPassageiroDTO dto) {

        ViagemPassageiroDTO created =
                service.create(dto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();


        return ResponseEntity
                .created(uri)
                .body(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ViagemPassageiroDTO> update(
            @Valid @RequestBody ViagemPassageiroDTO dto,
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.update(dto, id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}