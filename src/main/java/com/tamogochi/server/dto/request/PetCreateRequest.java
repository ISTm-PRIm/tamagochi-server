package com.tamogochi.server.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ApiModel("PetCreateRequest")
public class PetCreateRequest {
    private Long userId;
    @NotBlank
    @Size(max = 36)
    private String name;
}
