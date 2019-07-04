package us.circle.pineapple.admin.service;


import alpha.pineapple.ai.api.ErrResult;
import alpha.pineapple.ai.api.IUserMatchService;
import alpha.pineapple.ai.api.OKResult;
import alpha.pineapple.ai.api.Result;
import com.alibaba.dubbo.config.annotation.Service;
import io.swagger.annotations.Api;
import org.hswebframework.web.id.IDGenerator;
import org.hswebframework.web.service.DefaultDSLQueryService;
import org.hswebframework.web.service.DefaultDSLUpdateService;
import org.hswebframework.web.service.GenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.circle.pineapple.admin.api.UserMatch;
import us.circle.pineapple.admin.api.UserMatchService;
import us.circle.pineapple.admin.dao.UserMatchDao;

import java.util.Date;

/**
 * 默认的服务实现
 *
 * @author hsweb-generator3.0
 */
@Service(interfaceClass = IUserMatchService.class)
@Component("userMatchService")
@Api(tags = "",value="")
public class UserMatchServiceImpl extends GenericEntityService<UserMatch, Long>
        implements UserMatchService, IUserMatchService {
            
    @Autowired
    private UserMatchDao userMatchDao;
    
    @Override
    protected IDGenerator<Long> getIDGenerator() {
        return null;
    }

    @Override
    public UserMatchDao getDao() {
        return userMatchDao;
    }

    @Override
    public Result<Boolean> updateUserToken(String username, String token) {
        try {
            UserMatch userMatch = DefaultDSLQueryService.createQuery(getDao())
                    .select("*").where("username", username).single();
            if (userMatch == null) {
                UserMatch um = new UserMatch();
                um.setUsername(username);
                um.setLoginTime(new Date());
                um.setToken(token);

                insert(um);

                return new OKResult<Boolean>(Boolean.TRUE);
            } else {
                userMatch.setToken(token);
                userMatch.setLoginTime(new Date());
                updateByPk(userMatch);

                return new OKResult<Boolean>(Boolean.TRUE);
            }
        }
        catch (Exception e) {
            return new ErrResult<Boolean>(e.getMessage());
        }
    }

    @Override
    public Result<Boolean> updateUserCurMatch(String username, Long matchId) {
        try {
            UserMatch userMatch = DefaultDSLQueryService.createQuery(getDao())
                    .select("*").where("username", username).single();
            if (userMatch == null) {
                UserMatch um = new UserMatch();
                um.setUsername(username);
                um.setCurMatch(matchId);

                insert(um);

                return new OKResult<Boolean>(Boolean.TRUE);
            } else {
                userMatch.setCurMatch(matchId);
                updateByPk(userMatch);

                return new OKResult<Boolean>(Boolean.TRUE);
            }
        }
        catch (Exception e) {
            return new ErrResult<Boolean>(e.getMessage());
        }
    }

    @Override
    public Result<Boolean> clearUserCurMatch(String username) {
        try {
            getDao().clearCurMatch(username);
            return new OKResult<Boolean>(Boolean.TRUE);
        }
        catch (Exception e) {
            logger.error("", e);
            return new ErrResult<Boolean>(e.getMessage());
        }
    }

    @Override
    public Result<String> getUserToken(String username) {
        try {
            UserMatch userMatch = DefaultDSLQueryService.createQuery(getDao())
                    .select("token").where("username", username).single();
            if (userMatch == null) {
                return new OKResult<String>(null);
            } else {
                return new OKResult<String>(userMatch.getToken());
            }
        }
        catch (Exception e) {
            return new ErrResult<String>(e.getMessage());
        }
    }

    @Override
    public Result<Long> getUserCurMatch(String username) {
        try {
            UserMatch userMatch = DefaultDSLQueryService.createQuery(getDao())
                    .select("curMatch").where("username", username).single();
            if (userMatch == null) {
                return new OKResult<Long>(null);
            } else {
                return new OKResult<Long>(userMatch.getCurMatch());
            }
        }
        catch (Exception e) {
            return new ErrResult<Long>(e.getMessage());
        }
    }
}
