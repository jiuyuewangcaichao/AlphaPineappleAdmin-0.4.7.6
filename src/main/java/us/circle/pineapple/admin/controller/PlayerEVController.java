package us.circle.pineapple.admin.controller;

import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hswebframework.web.authorization.Permission;
import org.hswebframework.web.authorization.annotation.Authorize;
import org.hswebframework.web.commons.entity.PagerResult;
import org.hswebframework.web.commons.entity.param.QueryParamEntity;
import org.hswebframework.web.controller.SimpleGenericEntityController;
import org.hswebframework.web.controller.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import us.circle.pineapple.admin.api.PlayerEV;
import us.circle.pineapple.admin.api.PlayerEVService;
import us.circle.pineapple.admin.api.ScoreEVService;

import java.util.List;
import java.util.Map;

import static org.hswebframework.web.controller.message.ResponseMessage.ok;

/**
 * 
 * @author hsweb-generator3.0
 */
@RestController
@RequestMapping("/pineapple-player")
@Authorize(permission = "pineapple",description="")
@Api(tags = "",value="")
public class PlayerEVController implements SimpleGenericEntityController<PlayerEV, Long, QueryParamEntity> {

    private PlayerEVService playerEVService;
  
    @Autowired
    public void setPlayerEVService(PlayerEVService playerEVService) {
        this.playerEVService = playerEVService;
    }
  
    @Override
    public PlayerEVService getService() {
        return playerEVService;
    }

    @Authorize(action = Permission.ACTION_QUERY)
    @PostMapping("/filter-player")
    @ApiOperation(value = "根据动态条件查询", responseReference = "post")
    List<PlayerEV> filterPlayer(@RequestParam("key") String key) {
        QueryParamEntity qp = new QueryParamEntity();
        qp.where("playerId", "like", "%" + key + "%")
                .or("playerName", "like", "%" + key + "%");
        return getService().select(qp);
    }
}
