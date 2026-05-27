package com.caio557833.t_space.dto;

import com.caio557833.t_space.entity.Passageiro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassageiroDTO {

    private Long id;

    private String nome;

    private Integer idade;

    private String passaporte;

    private LocalDate dataCadastro;

    private String nacionalidade;

    public PassageiroDTO(Passageiro passageiro) {
        this.id = passageiro.getId();
        this.nome = passageiro.getNome();
        this.idade = passageiro.getIdade();
        this.passaporte = passageiro.getPassaporte();
        this.dataCadastro = passageiro.getDataCadastro();
        this.nacionalidade = passageiro.getNacionalidade();
    }
}
