package com.caio557833.t_space.dto;

import com.caio557833.t_space.entity.Status;
import com.caio557833.t_space.entity.ViagemPassageiro;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViagemPassageiroDTO {

    private Long id;

    @NotNull(message = "Data de partida é obrigatória")
    @Future(message = "Data de partida deve ser futura")
    private LocalDate dataPartida;

    @NotNull(message = "Preço é obrigatório")
    @Positive(message = "Preço deve ser maior que zero")
    private Double preco;

    @NotNull(message = "Duração é obrigatória")
    @Min(value = 1,
            message = "Duração mínima é de 1 dia")
    @Max(value = 365,
            message = "Duração máxima é de 365 dias")
    private Integer duracaoDias;

    @NotNull(message = "Viagem é obrigatória")
    @Positive(message = "ID da viagem inválido")
    private Long viagemId;

    @NotNull(message = "Passageiro é obrigatório")
    @Positive(message = "ID do passageiro inválido")
    private Long passageiroId;

    @NotNull(message = "Status é obrigatório")
    private Status status;

    public ViagemPassageiroDTO(ViagemPassageiro vp){
        this.id = vp.getId();
        this.dataPartida = vp.getDataPartida();
        this.preco = vp.getPreco();
        this.duracaoDias = vp.getDuracaoDias();
        this.viagemId = vp.getViagem().getId();
        this.passageiroId = vp.getPassageiro().getId();
        this.status = vp.getStatus();
    }
}