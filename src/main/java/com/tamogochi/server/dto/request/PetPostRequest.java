package com.tamogochi.server.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("PetPostRequest")
public class PetPostRequest {
    @NotBlank
    protected String petId;
}
