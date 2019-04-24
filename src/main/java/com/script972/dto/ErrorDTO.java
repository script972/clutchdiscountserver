package com.script972.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ErrorDTO {

    private int codeError;

    private String descriptionError;

}
