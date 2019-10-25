package com.tamogochi.server.dto.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("PetCreateRequest")
public class PetCreateRequest {
    private String userId;
    private String name;
}
