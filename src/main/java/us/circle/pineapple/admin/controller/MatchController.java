package us.circle.pineapple.admin.controller;

import io.swagger.annotations.Api;
import org.activiti.bpmn.model.StringDataObject;
import org.hswebframework.web.authorization.annotation.Authorize;
import org.hswebframework.web.commons.entity.param.QueryParamEntity;
import org.hswebframework.web.controller.SimpleGenericEntityController;
import us.circle.pineapple.admin.api.Match;
import us.circle.pineapple.admin.api.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.circle.pineapple.admin.dao.MatchDao;

/**
 * 
 * @author hsweb-generator3.0
 */
@RestController
@RequestMapping("/match")
@Authorize(permission = "pineapple",description="")
@Api(tags = "",value="")
public class MatchController implements SimpleGenericEntityController<Match, Long, QueryParamEntity> {

    private MatchService matchService;

    @Autowired
    private MatchDao dao;
  
    @Autowired
    public void setMatchService(MatchService matchService) {
        this.matchService = matchService;
    }
  
    @Override
    public MatchService getService() {
        return matchService;
    }


}
