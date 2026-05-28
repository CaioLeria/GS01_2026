package com.caio557833.t_space.dto;

import com.caio557833.t_space.entity.Passageiro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassageiroDetalheDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String passaporte;
    private LocalDate dataCadastro;
    private String nacionalidade;

    private List<ViagemPassageiroDTO> viagens;

    public PassageiroDetalheDTO(Passageiro passageiro){

        this.id = passageiro.getId();
        this.nome = passageiro.getNome();
        this.dataNascimento = passageiro.getDataNascimento();
        this.passaporte = passageiro.getPassaporte();
        this.dataCadastro = passageiro.getDataCadastro();
        this.nacionalidade = passageiro.getNacionalidade();

        this.viagens =
                passageiro.getViagensPassageiros()
                        .stream()
                        .map(ViagemPassageiroDTO::new)
                        .toList();
    }
}