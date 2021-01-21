package com.luizfelipe.atores.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtorDTO {

    private Integer id;
    private String nome;
    private String diretor;
    private Integer ano;
}
