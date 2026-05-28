package com.caio557833.t_space.entity;

import com.caio557833.t_space.dto.PassageiroDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_passageiro")
@EqualsAndHashCode(of = "id")
public class Passageiro {

    public Passageiro(PassageiroDTO dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.dataNascimento = dto.getDataNascimento();
        this.passaporte = dto.getPassaporte();
        this.dataCadastro = dto.getDataCadastro();
        this.nacionalidade = dto.getNacionalidade();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String passaporte;

    private LocalDate dataCadastro;

    private String nacionalidade;

    @OneToMany(mappedBy = "passageiro")
    private List<ViagemPassageiro> viagensPassageiros;
}