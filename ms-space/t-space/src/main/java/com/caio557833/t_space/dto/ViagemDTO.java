package com.caio557833.t_space.dto;

import com.caio557833.t_space.entity.Viagem;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViagemDTO {

    private Long id;

    @NotBlank(message = "Destino é obrigatório")
    @Size(min = 2, max = 100,
            message = "Destino deve ter entre 2 e 100 caracteres")
    private String destino;

    @NotBlank(message = "Empresa é obrigatória")
    @Size(min = 2, max = 100,
            message = "Empresa deve ter entre 2 e 100 caracteres")
    private String empresa;

    @NotBlank(message = "Descrição é obrigatória")
    @Size(min = 10, max = 500,
            message = "Descrição deve ter entre 10 e 500 caracteres")
    private String descricao;

    @NotNull(message = "Capacidade máxima é obrigatória")
    @Min(value = 1,
            message = "Capacidade deve ser no mínimo 1")
    @Max(value = 1000,
            message = "Capacidade excede o limite permitido")
    private Integer capacidadeMaxima;

    public ViagemDTO(Viagem viagem){
        this.id = viagem.getId();
        this.destino = viagem.getDestino();
        this.empresa = viagem.getEmpresa();
        this.descricao = viagem.getDescricao();
        this.capacidadeMaxima = viagem.getCapacidadeMaxima();
    }
}