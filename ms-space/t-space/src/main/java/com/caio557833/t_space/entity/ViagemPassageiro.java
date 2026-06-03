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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_partida", nullable = false)
    private LocalDate dataPartida;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "duracao_dias", nullable = false)
    private Integer duracaoDias;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_viagem", nullable = false, length = 30)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "viagem_id", nullable = false)
    private Viagem viagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passageiro_id", nullable = false)
    private Passageiro passageiro;

    public ViagemPassageiro(ViagemPassageiroDTO dto){
        this.id = dto.getId();
        this.dataPartida = dto.getDataPartida();
        this.preco = dto.getPreco();
        this.duracaoDias = dto.getDuracaoDias();
        this.status = dto.getStatus();

        if (dto.getViagemId() != null) {
            this.viagem = new Viagem();
            this.viagem.setId(dto.getViagemId());
        }
        if (dto.getPassageiroId() != null) {
            this.passageiro = new Passageiro();
            this.passageiro.setId(dto.getPassageiroId());
        }
    }
}