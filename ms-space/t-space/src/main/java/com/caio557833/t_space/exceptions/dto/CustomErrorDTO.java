package com.caio557833.t_space.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomErrorDTO {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
