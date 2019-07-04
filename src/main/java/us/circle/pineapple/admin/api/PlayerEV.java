package us.circle.pineapple.admin.api;

import org.hswebframework.web.commons.entity.SimpleGenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;
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
public class PlayerEV extends SimpleGenericEntity<Long> {
    
    @ApiModelProperty(value = "")
    private Long playerId;
    
    @ApiModelProperty(value = "")
    private String playerName;
    
    @ApiModelProperty(value = "")
    private Float gameScoreAvg;
    
    @ApiModelProperty(value = "")
    private Integer totalHandCount;
    
    @ApiModelProperty(value = "")
    private Integer totalFinalScore;
    
    @ApiModelProperty(value = "")
    private Date lastTime;
    
    @ApiModelProperty(value = "")
    private Integer totalFanCount;
    
    @ApiModelProperty(value = "")
    private Float playerEv;
    
    @ApiModelProperty(value = "")
    private Float fanRatio;

    @ApiModelProperty(value = "")
    private Integer playerType;

    @ApiModelProperty(value = "")
    private String playerComment;

    @ApiModelProperty(value = "")
    private String commentBy;
}