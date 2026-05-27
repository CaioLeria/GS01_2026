package com.caio557833.t_space.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FieldMessageDTO {

    private String fieldName;
    private String message;

}
