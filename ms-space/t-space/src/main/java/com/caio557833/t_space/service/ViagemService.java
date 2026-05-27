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
        return repository.findAll().stream().map(ViagemDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public ViagemDTO findById(Long id) {
        Viagem viagem = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado com ID: "+id));
        return new ViagemDTO(viagem);
    }

    @Transactional
    public ViagemDTO create(ViagemDTO dto) {
        Viagem viagem = new Viagem();
        viagem.setPreco(dto.getPreco());
        viagem.setDestino(dto.getDestino());
        viagem.setPassageiros(dto.getPassageiro());
        viagem.setDataPartida(dto.getDataPartida());
        viagem.setDuracaoDias(dto.getDuracaoDias());
        viagem.setStatus(dto.getStatus());

        Viagem saved = repository.save(viagem);

        return new ViagemDTO(saved);
    }


    @Transactional
    public ViagemDTO update(ViagemDTO dto, Long id) {
        Viagem viagem = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado com ID: "+id));
        viagem.setPreco(dto.getPreco());
        viagem.setDestino(dto.getDestino());
        viagem.setPassageiros(dto.getPassageiro());
        viagem.setDataPartida(dto.getDataPartida());
        viagem.setDuracaoDias(dto.getDuracaoDias());
        viagem.setStatus(dto.getStatus());

        Viagem saved = repository.save(viagem);

        return new ViagemDTO(saved);
    }

    @Transactional
    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado com ID: "+id);
        }

        repository.deleteById(id);
    }
}
