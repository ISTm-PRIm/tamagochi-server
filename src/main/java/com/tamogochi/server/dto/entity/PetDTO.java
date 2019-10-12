package com.tamogochi.server.dto.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Pet")
public class PetDTO {
    private String id;
    private String name;
    private Boolean isAlive;

    @ApiModelProperty(allowableValues = "range[0, 100]")
    private int foolIndicator;

    @ApiModelProperty(allowableValues = "range[0, 100]")
    private int healthIndicator;

    @ApiModelProperty(allowableValues = "range[0, 100]")
    private int cleanIndicator;

    @ApiModelProperty(allowableValues = "range[0, 100]")
    private int sleepIndicator;
}
