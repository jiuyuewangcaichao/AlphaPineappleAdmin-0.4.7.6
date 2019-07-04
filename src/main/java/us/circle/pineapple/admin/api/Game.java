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
public class Game extends SimpleGenericEntity<Long> {
    
    @ApiModelProperty(value = "")
    private String street0;
    
    @ApiModelProperty(value = "")
    private String street1;
    
    @ApiModelProperty(value = "")
    private String street2;
    
    @ApiModelProperty(value = "")
    private String street3;
    
    @ApiModelProperty(value = "")
    private String street4;
    
    @ApiModelProperty(value = "")
    private Integer p0Score;
    
    @ApiModelProperty(value = "")
    private Integer p1Score;
    
    @ApiModelProperty(value = "")
    private Integer aiScore;
    
    @ApiModelProperty(value = "")
    private Integer p0Royal;
    
    @ApiModelProperty(value = "")
    private Integer p1Royal;
    
    @ApiModelProperty(value = "")
    private Integer aiRoyal;
    
    @ApiModelProperty(value = "")
    private Integer p0Fan;
    
    @ApiModelProperty(value = "")
    private Integer p1Fan;
    
    @ApiModelProperty(value = "")
    private Integer aiFan;
    
    @ApiModelProperty(value = "")
    private Integer state;
    
    @ApiModelProperty(value = "")
    private String opt0;
    
    @ApiModelProperty(value = "")
    private String opt1;
    
    @ApiModelProperty(value = "")
    private String opt2;
    
    @ApiModelProperty(value = "")
    private String opt3;
    
    @ApiModelProperty(value = "")
    private String opt4;
    
    @ApiModelProperty(value = "")
    private String act0;
    
    @ApiModelProperty(value = "")
    private String act1;
    
    @ApiModelProperty(value = "")
    private String act2;
    
    @ApiModelProperty(value = "")
    private String act3;
    
    @ApiModelProperty(value = "")
    private String act4;
    
    @ApiModelProperty(value = "")
    private String user;
    
    @ApiModelProperty(value = "")
    private Boolean fav;
    
    @ApiModelProperty(value = "")
    private String bindId;
    
    @ApiModelProperty(value = "")
    private Integer bindPos;
    
    @ApiModelProperty(value = "")
    private Date createTime;
    
    @ApiModelProperty(value = "")
    private Date modifyTime;
    
    @ApiModelProperty(value = "")
    private Long matchId;

    public String getAct(int s) {
        if (s == 0) {
            return act0;
        }
        else if (s == 1) {
            return act1;
        }
        else if (s == 2) {
            return act2;
        }
        else if (s == 3) {
            return act3;
        }
        else if (s == 4) {
            return act4;
        }

        return null;
    }

    public String getOpt(int s) {
        if (s == 0) {
            return opt0;
        }
        else if (s == 1) {
            return opt1;
        }
        else if (s == 2) {
            return opt2;
        }
        else if (s == 3) {
            return opt3;
        }
        else if (s == 4) {
            return opt4;
        }

        return null;
    }
}