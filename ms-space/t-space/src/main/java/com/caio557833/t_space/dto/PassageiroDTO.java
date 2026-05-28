package com.caio557833.t_space.dto;

import com.caio557833.t_space.entity.Passageiro;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassageiroDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 120,
            message = "Nome deve possuir entre 3 e 120 caracteres")
    private String nome;

    @NotNull(message = "Data de nescimento é obrigatório")
    private LocalDate dataNascimento;

    @NotBlank(message = "Passaporte é obrigatório")
    @Size(min = 5, max = 20,
            message = "Passaporte deve possuir entre 5 e 20 caracteres")

    @NotNull(message = "Passaporte é obrigatória")
    private String passaporte;

    @NotNull(message = "Data de cadastro é obrigatória")
    @PastOrPresent(
            message = "Data de cadastro não pode ser futura")
    private LocalDate dataCadastro;

    @NotBlank(message = "Nacionalidade é obrigatória")
    @Size(min = 2, max = 60,
            message = "Nacionalidade inválida")
    private String nacionalidade;

    public PassageiroDTO(Passageiro passageiro){
        this.id = passageiro.getId();
        this.nome = passageiro.getNome();
        this.dataNascimento = passageiro.getDataNascimento();
        this.passaporte = passageiro.getPassaporte();
        this.dataCadastro = passageiro.getDataCadastro();
        this.nacionalidade = passageiro.getNacionalidade();
    }
}