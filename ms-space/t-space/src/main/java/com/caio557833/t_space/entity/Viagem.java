package com.caio557833.t_space.entity;

import com.caio557833.t_space.dto.ViagemDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destino;

    private LocalDate dataPartida;

    private Integer duracaoDias;

    private Double preco;

    private Status status;

    @OneToMany(mappedBy = "viagem")
    private List<Passageiro> passageiros;

    public Viagem(ViagemDTO dto) {
        this.id = dto.getId();
        this.destino = dto.getDestino();
        this.dataPartida = dto.getDataPartida();
        this.duracaoDias = dto.getDuracaoDias();
        this.preco = dto.getPreco();
        this.status = dto.getStatus();
    }
}
