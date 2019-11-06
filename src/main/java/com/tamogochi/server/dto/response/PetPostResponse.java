package com.tamogochi.server.dto.response;

import com.tamogochi.server.dto.entity.PetDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel("PetPostResponse")
public class PetPostResponse {
    private PetDTO pet;
}
