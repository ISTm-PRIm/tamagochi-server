package com.tamogochi.server.dto.request;

import com.tamogochi.server.entity.ActionType;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("PetApplyActionRequest")
public class PetApplyActionRequest {
    private ActionType action;
}
