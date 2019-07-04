package us.circle.pineapple.admin.service;

import org.hswebframework.ezorm.core.dsl.Query;
import org.hswebframework.ezorm.core.dsl.Update;
import org.hswebframework.web.authorization.AuthenticationHolder;
import org.hswebframework.web.authorization.token.UserToken;
import org.hswebframework.web.authorization.token.UserTokenHolder;
import org.hswebframework.web.authorization.token.UserTokenManager;
import org.hswebframework.web.commons.entity.GenericEntity;
import org.hswebframework.web.commons.entity.RecordCreationEntity;
import org.hswebframework.web.id.IDGenerator;
import org.hswebframework.web.service.GenericEntityService;
import org.hswebframework.web.validator.group.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import us.circle.pineapple.admin.api.PlayerEV;
import us.circle.pineapple.admin.api.PlayerEVService;
import us.circle.pineapple.admin.api.ScoreEV;
import us.circle.pineapple.admin.api.ScoreEVService;
import us.circle.pineapple.admin.dao.PlayerEVDao;
import us.circle.pineapple.admin.dao.ScoreEVDao;

/**
 * 默认的服务实现
 *
 * @author hsweb-generator3.0
 */
@Service("playerEVService")
public class PlayerEVServiceImpl extends GenericEntityService<PlayerEV, Long>
        implements PlayerEVService {
            
    @Autowired
    private PlayerEVDao playerEVDao;

    @Autowired
    private UserTokenManager userTokenManager;

    @Override
    protected IDGenerator<Long> getIDGenerator() {
        return null;
    }

    @Override
    public PlayerEVDao getDao() {
        return playerEVDao;
    }

    @Override
    public PlayerEV selectByPk(Long pk) {
        return null == pk ? null : (PlayerEV)((Query)this.createQuery().where("playerId", pk)).single();
    }

    @Override
    public int updateByPk(Long pk, PlayerEV entity) {
        Assert.notNull(pk, "primary key can not be null");
        Assert.notNull(entity, "entity can not be null");
        entity.setId(pk);
        String username = AuthenticationHolder.get().getUser().getUsername();
        entity.setCommentBy(username);

        this.tryValidate(entity, new Class[]{UpdateGroup.class});
        return ((Update)((Update)this.createUpdate(entity).when(entity instanceof RecordCreationEntity, (update) -> {
            update.and().excludes(new String[]{"creatorId", "createTime"});
        })).where("playerId", pk)).exec();
    }
}
