package com.caio557833.t_space.service;

import com.caio557833.t_space.dto.ViagemDTO;
import com.caio557833.t_space.entity.Viagem;
import com.caio557833.t_space.exceptions.ResourceNotFoundException;
import com.caio557833.t_space.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository repository;


    @Transactional(readOnly = true)
    public List<ViagemDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(ViagemDTO::new)
                .toList();
    }


    @Transactional(readOnly = true)
    public ViagemDTO findById(Long id) {

        Viagem viagem = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Viagem não encontrada com ID: " + id));

        return new ViagemDTO(viagem);
    }


    @Transactional
    public ViagemDTO create(ViagemDTO dto) {

        Viagem viagem = new Viagem(dto);

        Viagem saved = repository.save(viagem);

        return new ViagemDTO(saved);
    }


    @Transactional
    public ViagemDTO update(ViagemDTO dto, Long id) {

        Viagem viagem = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Viagem não encontrada com ID: " + id));

        viagem.setDestino(dto.getDestino());
        viagem.setEmpresa(dto.getEmpresa());
        viagem.setDescricao(dto.getDescricao());
        viagem.setCapacidadeMaxima(dto.getCapacidadeMaxima());

        Viagem saved = repository.save(viagem);

        return new ViagemDTO(saved);
    }


    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Viagem não encontrada com ID: " + id);
        }

        repository.deleteById(id);
    }
}