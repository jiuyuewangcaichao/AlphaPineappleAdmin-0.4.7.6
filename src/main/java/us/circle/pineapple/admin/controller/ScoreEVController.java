package us.circle.pineapple.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hswebframework.ezorm.core.param.Term;
import org.hswebframework.web.authorization.Permission;
import org.hswebframework.web.authorization.annotation.Authorize;
import org.hswebframework.web.commons.entity.PagerResult;
import org.hswebframework.web.commons.entity.param.QueryParamEntity;
import org.hswebframework.web.controller.SimpleGenericEntityController;
import org.hswebframework.web.controller.message.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import us.circle.pineapple.admin.api.ScoreEV;
import us.circle.pineapple.admin.api.ScoreEVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hswebframework.web.controller.message.ResponseMessage.ok;

/**
 * 
 * @author hsweb-generator3.0
 */
@RestController
@RequestMapping("/pineapple-score")
@Authorize(permission = "pineapple",description="")
@Api(tags = "",value="")
public class ScoreEVController implements SimpleGenericEntityController<ScoreEV, Long, QueryParamEntity> {

    private ScoreEVService scoreEVService;
  
    @Autowired
    public void setScoreEVService(ScoreEVService scoreEVService) {
        this.scoreEVService = scoreEVService;
    }
  
    @Override
    public ScoreEVService getService() {
        return scoreEVService;
    }
}
