package us.circle.pineapple.admin.api;

import org.hswebframework.web.commons.entity.SimpleGenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
* 
* @author hsweb-generator3.0
*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "")
public class ActErr extends SimpleGenericEntity<Long> {
    
    @ApiModelProperty(value = "")
    private Long matchId;
    
    @ApiModelProperty(value = "")
    private Long gameId;
    
    @ApiModelProperty(value = "")
    private Integer street;
    
    @ApiModelProperty(value = "")
    private String act;
    
    @ApiModelProperty(value = "")
    private String opt;
    
    @ApiModelProperty(value = "")
    private Boolean ignore;

    @ApiModelProperty(value = "")
    private Integer type;

    @ApiModelProperty(value = "")
    private String comment;
    
}