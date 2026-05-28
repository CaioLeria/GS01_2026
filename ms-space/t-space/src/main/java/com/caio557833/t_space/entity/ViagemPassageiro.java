package com.caio557833.t_space.entity;

import com.caio557833.t_space.dto.ViagemPassageiroDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_viagem_passageiro")
@EqualsAndHashCode(of = "id")
public class ViagemPassageiro {


    public ViagemPassageiro(ViagemPassageiroDTO dto){
        this.id = dto.getId();
        this.dataPartida = dto.getDataPartida();
        this.preco = dto.getPreco();
        this.duracaoDias = dto.getDuracaoDias();
        this.status = dto.getStatus();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPartida;

    private Double preco;

    private Integer duracaoDias;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_viagem")
    private Status status;


    @ManyToOne
    @JoinColumn(name = "viagem_id")
    private Viagem viagem;

    @ManyToOne
    @JoinColumn(name = "passageiro_id")
    private Passageiro passageiro;
}