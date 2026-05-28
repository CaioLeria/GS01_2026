package com.caio557833.t_space.entity;

import com.caio557833.t_space.dto.ViagemDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_viagem")
@EqualsAndHashCode(of = "id")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destino;

    private String empresa;

    private String descricao;

    private Integer capacidadeMaxima;

    @OneToMany(mappedBy = "viagem")
    private List<ViagemPassageiro> viagensPassageiros;

    public Viagem(ViagemDTO dto){
        this.id = dto.getId();
        this.destino = dto.getDestino();
        this.empresa = dto.getEmpresa();
        this.descricao = dto.getDescricao();
        this.capacidadeMaxima = dto.getCapacidadeMaxima();
    }
}