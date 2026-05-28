package com.caio557833.t_space.controller;

import com.caio557833.t_space.dto.PassageiroDTO;
import com.caio557833.t_space.dto.PassageiroDetalheDTO;
import com.caio557833.t_space.service.PassageiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/passageiro")
public class PassageiroController {

    @Autowired
    private PassageiroService service;


    @GetMapping
    public ResponseEntity<List<PassageiroDetalheDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PassageiroDetalheDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }


    @PostMapping
    public ResponseEntity<PassageiroDTO> create(
            @Valid @RequestBody PassageiroDTO dto) {

        PassageiroDTO created =
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
    public ResponseEntity<PassageiroDTO> update(
            @Valid @RequestBody PassageiroDTO dto,
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