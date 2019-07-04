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
public class UserMatch extends SimpleGenericEntity<Long> {
    
    @ApiModelProperty(value = "")
    private String username;
    
    @ApiModelProperty(value = "")
    private Date loginTime;
    
    @ApiModelProperty(value = "")
    private String token;
    
    @ApiModelProperty(value = "0 means deleted")
    private Integer state;
    
    @ApiModelProperty(value = "cur match id")
    private Long curMatch;
    
}