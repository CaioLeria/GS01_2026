package com.caio557833.t_space.service;

import com.caio557833.t_space.dto.PassageiroDTO;
import com.caio557833.t_space.dto.PassageiroDetalheDTO;
import com.caio557833.t_space.entity.Passageiro;
import com.caio557833.t_space.exceptions.ResourceNotFoundException;
import com.caio557833.t_space.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassageiroService {

    @Autowired
    private PassageiroRepository repository;


    @Transactional(readOnly = true)
    public List<PassageiroDetalheDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(PassageiroDetalheDTO::new)
                .toList();
    }


    @Transactional(readOnly = true)
    public PassageiroDetalheDTO findById(Long id) {

        Passageiro passageiro =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Passageiro não encontrado com ID: " + id));

        return new PassageiroDetalheDTO(passageiro);
    }


    @Transactional
    public PassageiroDTO create(PassageiroDTO dto) {

        Passageiro passageiro =
                new Passageiro(dto);

        Passageiro saved =
                repository.save(passageiro);

        return new PassageiroDTO(saved);
    }


    @Transactional
    public PassageiroDTO update(PassageiroDTO dto, Long id) {

        Passageiro passageiro =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Passageiro não encontrado com ID: " + id));

        passageiro.setNome(dto.getNome());
        passageiro.setDataNascimento(dto.getDataNascimento());
        passageiro.setPassaporte(dto.getPassaporte());
        passageiro.setDataCadastro(dto.getDataCadastro());
        passageiro.setNacionalidade(dto.getNacionalidade());

        Passageiro saved =
                repository.save(passageiro);

        return new PassageiroDTO(saved);
    }


    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Passageiro não encontrado com ID: " + id);
        }

        repository.deleteById(id);
    }
}