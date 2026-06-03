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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 120)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "passaporte", nullable = false, length = 20)
    private String passaporte;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "nacionalidade", nullable = false, length = 60)
    private String nacionalidade;

    @OneToMany(mappedBy = "passageiro")
    private List<ViagemPassageiro> viagensPassageiros;

    public Passageiro(PassageiroDTO dto){
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.dataNascimento = dto.getDataNascimento();
        this.passaporte = dto.getPassaporte();
        this.dataCadastro = dto.getDataCadastro();
        this.nacionalidade = dto.getNacionalidade();
    }
}