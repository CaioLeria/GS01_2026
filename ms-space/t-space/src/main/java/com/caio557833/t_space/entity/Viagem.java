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

    @Column(name = "destino", nullable = false, length = 100)
    private String destino;

    @Column(name = "empresa", nullable = false, length = 100)
    private String empresa;

    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;

    @Column(name = "capacidade_maxima", nullable = false)
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