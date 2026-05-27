package com.caio557833.t_space.dto;

import com.caio557833.t_space.entity.Passageiro;
import com.caio557833.t_space.entity.Status;
import com.caio557833.t_space.entity.Viagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViagemDTO {

    private Long id;

    private String destino;

    private LocalDate dataPartida;

    private Integer duracaoDias;

    private Double preco;

    private Status status;

    private List<Passageiro> passageiro;

    public ViagemDTO(Viagem viagem) {
        this.destino = viagem.getDestino();
        this.dataPartida = viagem.getDataPartida();
        this.duracaoDias = viagem.getDuracaoDias();
        this.preco = viagem.getPreco();
        this.status = viagem.getStatus();
        this.passageiro = viagem.getPassageiros();
    }

}
