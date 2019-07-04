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
public class ScoreEV extends SimpleGenericEntity<Long> {

    @ApiModelProperty(value = "")
    private Long playerId;
    
    @ApiModelProperty(value = "")
    private String playerName;
    
    @ApiModelProperty(value = "")
    private Integer gameScore;
    
    @ApiModelProperty(value = "")
    private Integer totalHandCount;
    
    @ApiModelProperty(value = "")
    private Integer totalFinalScore;
    
    @ApiModelProperty(value = "")
    private java.util.Date lastTime;
    
    @ApiModelProperty(value = "")
    private Integer totalFanCount;
    
    @ApiModelProperty(value = "")
    private Double playerEv;
    
    @ApiModelProperty(value = "")
    private Double fanRatio;
    
}