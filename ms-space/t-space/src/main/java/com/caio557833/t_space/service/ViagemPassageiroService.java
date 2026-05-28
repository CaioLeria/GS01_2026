package com.caio557833.t_space.service;

import com.caio557833.t_space.dto.ViagemPassageiroDTO;
import com.caio557833.t_space.entity.Passageiro;
import com.caio557833.t_space.entity.Viagem;
import com.caio557833.t_space.entity.ViagemPassageiro;
import com.caio557833.t_space.exceptions.ResourceNotFoundException;
import com.caio557833.t_space.repository.PassageiroRepository;
import com.caio557833.t_space.repository.ViagemPassageiroRepository;
import com.caio557833.t_space.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ViagemPassageiroService {

    @Autowired
    private ViagemPassageiroRepository repository;

    @Autowired
    private ViagemRepository viagemRepository;

    @Autowired
    private PassageiroRepository passageiroRepository;


    @Transactional(readOnly = true)
    public List<ViagemPassageiroDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(ViagemPassageiroDTO::new)
                .toList();
    }


    @Transactional(readOnly = true)
    public ViagemPassageiroDTO findById(Long id) {

        ViagemPassageiro viagemPassageiro = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Reserva não encontrada com ID: " + id));

        return new ViagemPassageiroDTO(viagemPassageiro);
    }


    @Transactional
    public ViagemPassageiroDTO create(ViagemPassageiroDTO dto) {

        Viagem viagem = viagemRepository.findById(dto.getViagemId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Viagem não encontrada"));

        Passageiro passageiro = passageiroRepository.findById(dto.getPassageiroId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Passageiro não encontrado"));

        ViagemPassageiro viagemPassageiro =
                new ViagemPassageiro(dto);

        viagemPassageiro.setViagem(viagem);
        viagemPassageiro.setPassageiro(passageiro);
        viagemPassageiro.setStatus(dto.getStatus());

        ViagemPassageiro saved =
                repository.save(viagemPassageiro);

        return new ViagemPassageiroDTO(saved);
    }


    @Transactional
    public ViagemPassageiroDTO update(
            ViagemPassageiroDTO dto,
            Long id) {

        ViagemPassageiro viagemPassageiro =
                repository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Reserva não encontrada com ID: " + id));

        Viagem viagem =
                viagemRepository.findById(dto.getViagemId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Viagem não encontrada"));

        Passageiro passageiro =
                passageiroRepository.findById(dto.getPassageiroId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Passageiro não encontrado"));

        viagemPassageiro.setDataPartida(dto.getDataPartida());
        viagemPassageiro.setPreco(dto.getPreco());
        viagemPassageiro.setDuracaoDias(dto.getDuracaoDias());
        viagemPassageiro.setStatus(dto.getStatus());
        viagemPassageiro.setViagem(viagem);
        viagemPassageiro.setPassageiro(passageiro);

        ViagemPassageiro saved =
                repository.save(viagemPassageiro);

        return new ViagemPassageiroDTO(saved);
    }


    @Transactional
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "Reserva não encontrada com ID: " + id);
        }

        repository.deleteById(id);
    }
}