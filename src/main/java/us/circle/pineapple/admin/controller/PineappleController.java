package us.circle.pineapple.admin.controller;

import io.swagger.annotations.Api;
import org.hswebframework.web.authorization.annotation.Authorize;
import org.hswebframework.web.commons.entity.param.QueryParamEntity;
import org.hswebframework.web.controller.SimpleGenericEntityController;
import org.springframework.web.bind.annotation.ResponseBody;
import us.circle.pineapple.admin.api.Pineapple;
import us.circle.pineapple.admin.api.PineappleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author hsweb-generator3.0
 */
@RestController
@RequestMapping("/pineapple")
@Authorize(permission = "pineapple",description="")
@Api(tags = "",value="")
public class PineappleController implements SimpleGenericEntityController<Pineapple, Long, QueryParamEntity> {

    private PineappleService pineappleService;
  
    @Autowired
    public void setPineappleService(PineappleService pineappleService) {
        this.pineappleService = pineappleService;
    }
  
    @Override
    public PineappleService getService() {
        return pineappleService;
    }


}
