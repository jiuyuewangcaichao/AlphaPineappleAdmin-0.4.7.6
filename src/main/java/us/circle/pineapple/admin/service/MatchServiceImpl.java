package us.circle.pineapple.admin.service;

import alpha.pineapple.ai.api.*;
import com.alibaba.dubbo.config.annotation.Service;
import io.swagger.annotations.Api;
import org.hswebframework.web.service.DefaultDSLQueryService;
import org.hswebframework.web.service.DefaultDSLUpdateService;
import org.hswebframework.web.service.GenericEntityService;
import org.hswebframework.web.id.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.circle.pineapple.admin.api.Match;
import us.circle.pineapple.admin.api.MatchService;
import us.circle.pineapple.admin.dao.MatchDao;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 默认的服务实现
 *
 * @author hsweb-generator3.0
 */
@Service(interfaceClass = IMatchService.class)
@Component("matchService")
@Api(tags = "",value="")
public class MatchServiceImpl extends GenericEntityService<Match, Long>
        implements MatchService, IMatchService {
            
    @Autowired
    private MatchDao matchDao;
    
    @Override
    protected IDGenerator<Long> getIDGenerator() {
        return null;
    }

    @Override
    public MatchDao getDao() {
        return matchDao;
    }

    @Override
    public int updateByPk(Long pk, Match entity) {
        if (entity.getAiScore() != null && entity.getP0Score() + entity.getP1Score() + entity.getAiScore() != 0) {
            throw new RuntimeException("3人得分之和不为0");
        }
        return super.updateByPk(pk, entity);
    }

    @Override
    public Result<Long> openNewMatch(String username) {
        try {
            Match m = new Match();
            m.setStartTime(LocalDateTime.now());
            m.setUsername(username);
            Long newId = insert(m);
            return new OKResult<Long>(newId);
        }
        catch (Exception e) {
            return new ErrResult<Long>(e.getMessage());
        }
    }

    @Override
    public Result<Boolean> finishMatch(String username, Long id) {
        try {
            Match m = DefaultDSLQueryService.createQuery(getDao())
                    .select("finishTime", "username")
                    .where("id", id)
                    .single();
            if (m == null) {
                throw new RuntimeException("match [" + id + "] not exist");
            }
            if (!m.getUsername().equals(username)) {
                throw new RuntimeException("match not owned by " + username);
            }
            if (m.getFinishTime() != null) {
                throw new RuntimeException("match [" + id + "] already finished");
            }

            DefaultDSLUpdateService.createUpdate(getDao())
                    .set("finishTime", LocalDateTime.now())
                    .where("id", id)
                    .exec();
            return new OKResult<Boolean>(Boolean.TRUE);
        }
        catch (Exception e) {
            return new ErrResult<Boolean>(e.getMessage());
        }
    }
}
