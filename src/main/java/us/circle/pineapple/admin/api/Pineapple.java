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
public class Pineapple extends SimpleGenericEntity<Long> {

    @ApiModelProperty(value = "")
    private Long gameId;
    
    @ApiModelProperty(value = "")
    private String gameName;
    
    @ApiModelProperty(value = "")
    private Integer gameScore;
    
    @ApiModelProperty(value = "")
    private Integer playerCount;
    
    @ApiModelProperty(value = "")
    private Double gameDuration;
    
    @ApiModelProperty(value = "")
    private Integer handCount;
    
    @ApiModelProperty(value = "")
    private Long playerId;
    
    @ApiModelProperty(value = "")
    private String playerName;
    
    @ApiModelProperty(value = "")
    private Long clubId;
    
    @ApiModelProperty(value = "")
    private String clubName;
    
    @ApiModelProperty(value = "")
    private Integer scoreIn;
    
    @ApiModelProperty(value = "")
    private Integer scoreOut;
    
    @ApiModelProperty(value = "")
    private Integer finalScore;
    
    @ApiModelProperty(value = "")
    private Date endTime;
    
    @ApiModelProperty(value = "")
    private Integer fanCount;
    
    @ApiModelProperty(value = "")
    private Integer totalFanCount;
    
}