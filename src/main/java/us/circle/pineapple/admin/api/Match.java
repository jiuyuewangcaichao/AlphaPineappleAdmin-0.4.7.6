package us.circle.pineapple.admin.api;
import org.hswebframework.web.commons.entity.SimpleGenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
public class Match extends SimpleGenericEntity<Long> {

    @ApiModelProperty(value = "")
    private String name;

    @ApiModelProperty(value = "")
    private LocalDateTime startTime;
    
    @ApiModelProperty(value = "")
    private LocalDateTime finishTime;
    
    @ApiModelProperty(value = "")
    private String p0;
    
    @ApiModelProperty(value = "")
    private String p1;
    
    @ApiModelProperty(value = "")
    private String ai;
    
    @ApiModelProperty(value = "")
    private Integer level;
    
    @ApiModelProperty(value = "0是联盟局，1为私局")
    private Integer type;
    
    @ApiModelProperty(value = "")
    private Integer p0Score;
    
    @ApiModelProperty(value = "")
    private Integer p1Score;
    
    @ApiModelProperty(value = "")
    private Integer aiScore;
    
    @ApiModelProperty(value = "")
    private Integer hand;
    
    @ApiModelProperty(value = "")
    private Integer k3Fan;
    
    @ApiModelProperty(value = "")
    private Integer aceFan;
    
    @ApiModelProperty(value = "")
    private Integer kingFan;
    
    @ApiModelProperty(value = "")
    private Integer queenFan;
    
    @ApiModelProperty(value = "")
    private Double k3AvgScore;
    
    @ApiModelProperty(value = "")
    private Double aceAvgScore;
    
    @ApiModelProperty(value = "")
    private Double kingAvgScore;
    
    @ApiModelProperty(value = "")
    private Double queenAvgScore;

    @ApiModelProperty(value = "")
    private String username;
}