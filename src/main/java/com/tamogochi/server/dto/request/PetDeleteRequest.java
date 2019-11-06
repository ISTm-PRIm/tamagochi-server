package com.tamogochi.server.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("PetDeleteRequest")
public class PetDeleteRequest {
    @NotBlank
    protected String petId;
}
