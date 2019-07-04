package us.circle.pineapple.admin.service;

import alpha.pineapple.ai.api.ErrResult;
import alpha.pineapple.ai.api.IGameHandService;
import alpha.pineapple.ai.api.OKResult;
import alpha.pineapple.ai.api.Result;
import alpha.pineapple.ai.api.entity.GameHand;
import com.alibaba.dubbo.config.annotation.Service;
import io.swagger.annotations.Api;
import org.hswebframework.ezorm.core.dsl.Query;
import org.hswebframework.ezorm.core.dsl.Update;
import org.hswebframework.web.bean.FastBeanCopier;
import org.hswebframework.web.commons.entity.param.QueryParamEntity;
import org.hswebframework.web.commons.entity.param.UpdateParamEntity;
import org.hswebframework.web.service.DefaultDSLQueryService;
import org.hswebframework.web.service.DefaultDSLUpdateService;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Component;
import us.circle.pineapple.admin.api.Game;
import us.circle.pineapple.admin.api.GameService;
import us.circle.pineapple.admin.api.Match;
import us.circle.pineapple.admin.dao.GameDao;
import org.hswebframework.web.service.GenericEntityService;
import org.hswebframework.web.id.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 默认的服务实现
 *
 * @author hsweb-generator3.0
 */
@Service(interfaceClass = IGameHandService.class)
@Component("gameService")
@Api(tags = "",value="")
public class GameServiceImpl extends GenericEntityService<Game, Long>
        implements GameService, IGameHandService {
            
    @Autowired
    private GameDao gameDao;
    
    @Override
    protected IDGenerator<Long> getIDGenerator() {
        return null;
    }

    @Override
    public GameDao getDao() {
        return gameDao;
    }


    @Override
    public Result<Long> createGameHand(String username, Long matchId, String bindId, Integer bindPos) {
        try {
            Game game = new Game();
            game.setUser(username);
            game.setMatchId(matchId);
            game.setBindId(bindId);
            game.setBindPos(bindPos);
            game.setState(0);
            game.setCreateTime(new Date());
            game.setModifyTime(new Date());

            Long newId = insert(game);
            return new OKResult<Long>(newId);
        }
        catch (Exception e) {
            return new ErrResult<Long>(e.getMessage());
        }
    }

    @Override
    public Result<Boolean> updateGameHandSelective(Long pk, GameHand hand) {
        try {
            if (pk == null) {
                throw new RuntimeException("pk is not specified");
            }

            Update<Object, UpdateParamEntity<Object>> update = DefaultDSLUpdateService.createUpdate(getDao());

            if (hand.getStreet0() != null) {
                update.set("street0", hand.getStreet0());
            }

            if (hand.getStreet1() != null) {
                update.set("street1", hand.getStreet1());
            }

            if (hand.getStreet2() != null) {
                update.set("street2", hand.getStreet2());
            }

            if (hand.getStreet3() != null) {
                update.set("street3", hand.getStreet3());
            }

            if (hand.getStreet4() != null) {
                update.set("street4", hand.getStreet4());
            }

            if (hand.getP0Score() != null) {
                update.set("p0Score", hand.getP0Score());
            }

            if (hand.getP1Score() != null) {
                update.set("p1Score", hand.getP1Score());
            }

            if (hand.getAiScore() != null) {
                update.set("aiScore", hand.getAiScore());
            }

            if (hand.getP0Royal() != null) {
                update.set("p0Royal", hand.getP0Royal());
            }

            if (hand.getP1Royal() != null) {
                update.set("p1Royal", hand.getP1Royal());
            }

            if (hand.getAiRoyal() != null) {
                update.set("aiRoyal", hand.getAiRoyal());
            }

            if (hand.getP0Fan() != null) {
                update.set("p0Fan", hand.getP0Fan());
            }

            if (hand.getP1Fan() != null) {
                update.set("p1Fan", hand.getP1Fan());
            }

            if (hand.getAiFan() != null) {
                update.set("aiFan", hand.getAiFan());
            }

            if (hand.getState() != null) {
                update.set("state", hand.getState());
            }

            if (hand.getOpt0() != null) {
                update.set("opt0", hand.getOpt0());
            }

            if (hand.getOpt1() != null) {
                update.set("opt1", hand.getOpt1());
            }

            if (hand.getOpt2() != null) {
                update.set("opt2", hand.getOpt2());
            }

            if (hand.getOpt3() != null) {
                update.set("opt3", hand.getOpt3());
            }

            if (hand.getOpt4() != null) {
                update.set("opt4", hand.getOpt4());
            }

            if (hand.getAct0() != null) {
                update.set("act0", hand.getAct0());
            }

            if (hand.getAct1() != null) {
                update.set("act1", hand.getAct1());
            }

            if (hand.getAct2() != null) {
                update.set("act2", hand.getAct2());
            }

            if (hand.getAct3() != null) {
                update.set("act3", hand.getAct3());
            }

            if (hand.getAct4() != null) {
                update.set("act4", hand.getAct4());
            }

            if (hand.getUser() != null) {
                update.set("user", hand.getUser());
            }

            if (hand.getFav() != null) {
                update.set("fav", hand.getFav());
            }

            if (hand.getBindId() != null) {
                update.set("bindId", hand.getBindId());
            }

            if (hand.getBindPos() != null) {
                update.set("bindPos", hand.getBindPos());
            }

            if (hand.getCreateTime() != null) {
                update.set("createTime", hand.getCreateTime());
            }

            if (hand.getModifyTime() != null) {
                update.set("modifyTime", hand.getModifyTime());
            }

            if (hand.getMatchId() != null) {
                update.set("matchId", hand.getMatchId());
            }

            update.where("id", pk).exec();

            return new OKResult<Boolean>(Boolean.TRUE);
        }
        catch (Exception e) {
            return new ErrResult<Boolean>(e.getMessage());
        }
    }

    @Override
    public Result<GameHand> selectNextHandStreets(Long startGameHandId, String username, boolean marked, boolean desc) {
        try {
            Query<Game, QueryParamEntity> query = DefaultDSLQueryService.createQuery(getDao())
                    .select("id", "street0", "street1", "street2", "street3", "street4", "user", "aiFan", "bindId", "bindPos", "createTime").where().and();
            if (desc) {
                query.lte("id", startGameHandId);
            }
            else {
                query.gte("id", startGameHandId);
            }

            if (marked) {
                query.and("fav", marked);
            }

            if (username != null) {
                query.and("user", username);
            }

            if (desc) {
                query.orderByDesc("id");
            }
            else {
                query.orderByAsc("id");
            }

            Game g = query.doPaging(0, 1).single();
            if (g == null) {
                return new OKResult<GameHand>(null);
            }

            GameHand hand = new GameHand();
            FastBeanCopier.copy(g, hand);
            return new OKResult<GameHand>(hand);
        }
        catch (Exception e) {
            return new ErrResult<GameHand>(e.getMessage());
        }
    }
}
