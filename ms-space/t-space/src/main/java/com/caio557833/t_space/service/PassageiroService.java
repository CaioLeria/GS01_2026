package com.caio557833.t_space.service;

import com.caio557833.t_space.dto.PassageiroDTO;
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
    public List<PassageiroDTO> findAll() {
        return repository.findAll().stream().map(PassageiroDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public PassageiroDTO findById(Long id) {
        Passageiro passageiro = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado com ID: "+id));

        return new PassageiroDTO(passageiro);
    }

    @Transactional
    public PassageiroDTO create(PassageiroDTO dto) {
        Passageiro passageiro = new Passageiro();
        passageiro.setNome(dto.getNome());
        passageiro.setIdade(dto.getIdade());
        passageiro.setPassaporte(dto.getPassaporte());
        passageiro.setNacionalidade(dto.getNacionalidade());
        passageiro.setDataCadastro(dto.getDataCadastro());

        Passageiro saved = repository.save(passageiro);

        return new PassageiroDTO(saved);
    }


    @Transactional
    public PassageiroDTO update(PassageiroDTO dto, Long id) {
        Passageiro passageiro = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado com ID: "+id));
        passageiro.setNome(dto.getNome());
        passageiro.setIdade(dto.getIdade());
        passageiro.setPassaporte(dto.getPassaporte());
        passageiro.setDataCadastro(dto.getDataCadastro());
        passageiro.setNacionalidade(dto.getNacionalidade());

        Passageiro saved = repository.save(passageiro);

        return new PassageiroDTO(saved);
    }


    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado com ID: "+id);
        }

        repository.deleteById(id);
    }
}
