package us.circle.pineapple.admin.service;

import us.circle.pineapple.admin.api.PineappleService;
import us.circle.pineapple.admin.dao.PineappleDao;
import us.circle.pineapple.admin.api.Pineapple;
import org.hswebframework.web.service.GenericEntityService;
import org.hswebframework.web.id.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 默认的服务实现
 *
 * @author hsweb-generator3.0
 */
@Service("pineappleService")
public class PineappleServiceImpl extends GenericEntityService<Pineapple, Long>
        implements PineappleService {
            
    @Autowired
    private PineappleDao pineappleDao;
    
    @Override
    protected IDGenerator<Long> getIDGenerator() {
        return null;
    }

    @Override
    public PineappleDao getDao() {
        return pineappleDao;
    }

}
