package com.tamogochi.server.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@ApiModel("PetCreateRequest")
public class PetCreateRequest {
    @Size(max = 36)
    private String userId;
    @Size(max = 36)
    private String name;
}
