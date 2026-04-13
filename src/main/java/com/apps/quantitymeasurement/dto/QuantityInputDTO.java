package com.apps.quantitymeasurement.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class QuantityInputDTO {

    @NotNull(message = "thisQuantityDTO cannot be null")
    @Valid
    private QuantityDTO thisQuantityDTO;

    @NotNull(message = "thatQuantityDTO cannot be null")
    @Valid
    private QuantityDTO thatQuantityDTO;
}