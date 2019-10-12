package com.tamogochi.server.dto.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Version")
public class VersionDto {
    @ApiModelProperty(
            value = "Версия в формате &lt;version &gt;.&lt;git branch &gt;.&lt;commit hash&gt;.&lt;commits count&gt;",
            example = "1.0.0.master.0716af9.42"
    )
    private String version;
}
