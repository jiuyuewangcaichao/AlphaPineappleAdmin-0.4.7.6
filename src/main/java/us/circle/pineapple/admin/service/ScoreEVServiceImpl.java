package us.circle.pineapple.admin.service;

import us.circle.pineapple.admin.dao.ScoreEVDao;
import us.circle.pineapple.admin.api.ScoreEV;
import us.circle.pineapple.admin.api.ScoreEVService;
import org.hswebframework.web.service.GenericEntityService;
import org.hswebframework.web.id.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 默认的服务实现
 *
 * @author hsweb-generator3.0
 */
@Service("scoreEVService")
public class ScoreEVServiceImpl extends GenericEntityService<ScoreEV, Long>
        implements ScoreEVService {
            
    @Autowired
    private ScoreEVDao scoreEVDao;
    
    @Override
    public ScoreEVDao getDao() {
        return scoreEVDao;
    }

    @Override
    protected IDGenerator<Long> getIDGenerator() {
        return null;
    }
}
