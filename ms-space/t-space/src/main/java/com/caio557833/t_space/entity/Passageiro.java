package com.caio557833.t_space.entity;

import com.caio557833.t_space.dto.PassageiroDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Passageiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer idade;

    private String passaporte;

    private LocalDate dataCadastro;

    private String nacionalidade;

    @ManyToOne
    @JoinColumn(name = "viagem_id")
    private Viagem viagem;

    public Passageiro(PassageiroDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.idade = dto.getIdade();
        this.passaporte = dto.getPassaporte();
        this.dataCadastro = dto.getDataCadastro();
        this.nacionalidade = dto.getNacionalidade();
    }
}
