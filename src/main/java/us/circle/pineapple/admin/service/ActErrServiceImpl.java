package us.circle.pineapple.admin.service;

import org.hswebframework.web.service.GenericEntityService;
import org.hswebframework.web.id.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.circle.pineapple.admin.api.ActErr;
import us.circle.pineapple.admin.api.ActErrService;
import us.circle.pineapple.admin.dao.ActErrDao;

/**
 *
 * @author hsweb-generator3.0
 */
@Service("actErrService")
public class ActErrServiceImpl extends GenericEntityService<ActErr, Long>
        implements ActErrService {
            
    @Autowired
    private ActErrDao actErrDao;
    
    @Override
    protected IDGenerator<Long> getIDGenerator() {
        return null;
    }

    @Override
    public ActErrDao getDao() {
        return actErrDao;
    }

}
