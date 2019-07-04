package us.circle.pineapple.admin.job;

import alpha.pineapple.ai.api.model.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.hswebframework.web.commons.entity.param.QueryParamEntity;
import org.hswebframework.web.service.DefaultDSLQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.circle.pineapple.admin.api.*;
import us.circle.pineapple.admin.dao.GameDao;
import us.circle.pineapple.admin.dao.MatchDao;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class MatchAnalysisJob {

    @Autowired
    private MatchDao matchDao;

    @Autowired
    private MatchService matchService;

    @Autowired
    private GameDao gameDao;

    @Autowired
    private ActErrService actErrService;

    private List<Match> listUnAnalysisedMatches() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start = now.minusHours(1);

        return DefaultDSLQueryService.createQuery(matchDao)
                .select("*")
                .where()
                .and()
                .isNull("aceFan")
//                .and("finishTime", "gte", start)
//                .and("finishTime", "lt", now)
                .and()
                .notNull("aiScore")
                .listNoPaging();
    }

    private List<Game> listGamesOfMatch(Long matchId) {
        return DefaultDSLQueryService.createQuery(gameDao)
                .select("*")
                .where("matchId", matchId)
                .orderByAsc("id")
                .listNoPaging();
    }

    @Scheduled(initialDelay = 1000, fixedRate = 3600000)
    public void run() {
        log.info("start fan avg job ...");
        try {
            List<Match> list = listUnAnalysisedMatches();
            for (Match m : list) {
                analysisMatch(m);
            }
        }
        catch (Exception e) {
            log.error("", e);
        }
        log.info("end fan avg job ...");
    }

    private void analysisMatch(Match m) {
        log.info("start analysis match[{}] ...", m.getId());

        int k3 = 0;
        int a = 0;
        int k = 0;
        int q = 0;

        double k3Score = 0;
        double aScore = 0;
        double kScore = 0;
        double qScore = 0;

        int lastFanType = 0;
        OFCHand lastFanHand = null;
        List<Game> list = listGamesOfMatch(m.getId());
        int usedCount = 0;
        for (Game g: list) {
            if (!JobUtil.isUselessGame(g)) {
                usedCount ++;
                int curFanType = g.getAiFan();
                if (curFanType > 0) {
                    if (g.getStreet4() == null || g.getOpt4() == null) {
                        insertActMissing(g, 4);
                        continue;
                    }
                    OFCGameState gState = OFCGameState.fromDump(g.getStreet4());
                    OFCHand curFanHand = gState.getAi().getCurHand();
                    if (curFanHand.equals(lastFanHand)) {
                        // 重复手牌
                        continue;
                    }
                    lastFanHand = curFanHand;

                    EVList evList = EVList.fromDump(g.getOpt4());
                    ActionInfo optEV = evList.getFirst();
                    double optScore = optEV.getEv().getScore();
                    if (curFanType == 17) {
                        if (lastFanType == 0)
                            k3++;
                        k3Score += optScore;
                    }
                    else if (curFanType == 16) {
                        if (lastFanType == 0)
                            a ++;
                        aScore += optScore;
                    }
                    else if (curFanType == 15) {
                        if (lastFanType == 0)
                            k ++;
                        kScore += optScore;
                    }
                    else if (curFanType == 14) {
                        if (lastFanType == 0)
                            q ++;
                        qScore += optScore;
                    }
                }
                else {
                    analysisActErr(g);
                }
                lastFanType = curFanType;
            }
        }

        if (usedCount == 0) {
            return;
        }

        m.setK3Fan(k3);
        m.setAceFan(a);
        m.setKingFan(k);
        m.setQueenFan(q);

        if (k3 > 0)
            m.setK3AvgScore(k3Score / k3);
        if (a > 0)
            m.setAceAvgScore(aScore / a);
        if (k > 0)
            m.setKingAvgScore(kScore / k);
        if (q > 0)
            m.setQueenAvgScore(qScore / q);

        matchService.updateByPk(m.getId(), m);
        log.info("end analysis match[{}] ...", m.getId());
    }

    private void analysisActErr(Game game) {

        if ( StringUtils.isNotBlank(game.getAct0()) && StringUtils.isNotBlank(game.getOpt0()))
       // if (((game.getAct0()!=null)||(!game.getAct0().equals(""))) && ((game.getOpt0()!=null)||(!game.getOpt0().equals(""))))
            {
          Action act = Action.fromDump(game.getAct0());

            EVList list = EVList.fromDump(game.getOpt0());





            for (ActionInfo p : list) {
                if (list.indexOf(p) >= 3) {
                    insertActErr(game, 0);
                    break;
                }
                if (p.getAction().equals(act) && list.indexOf(p) < 3) {
                    if (list.indexOf(p) != 0) {
                        insertActWarn(game, 0);
                    }
                    break;
                }
            }
        }
        else {
            insertActMissing(game, 0);
        }

        for (int s = 1; s < 5; s ++ ) {
            if (StringUtils.isNotBlank(game.getAct(s))  && StringUtils.isNotBlank(game.getOpt(s))){
                Action act = Action.fromDump(game.getAct(s));
                 EVList list = EVList.fromDump(game.getOpt(s));
                ActionEV firstEV = list.getFirst().getEv();
                double optEV = firstEV.getEv() + firstEV.getBonus();

                for (ActionInfo p: list) {
                    if (p.getAction().equals(act)) {
                        double selEV = p.getEv().getEv() + p.getEv().getBonus();
                        if (Math.abs(selEV - optEV) > 0.01) {
                            insertActErr(game, s);
                        }
                        break;
                    }
                }
            }
            else {
                insertActMissing(game, s);
            }
        }
    }

    private void insertActErr(Game game, int s) {
        insertActErrType(game, s, 1);
    }

    private void insertActWarn(Game game, int s) {
        insertActErrType(game, s, 0);
    }

    private void insertActMissing(Game game, int s) {
        insertActErrType(game, s, -1);
    }

    private void insertActErrType(Game game, int s, int type) {
        QueryParamEntity param = QueryParamEntity.empty();
        param.and("gameId", game.getId()).and("matchId", game.getMatchId()).and("street", s);

        if (actErrService.selectSingle(param) == null) {
            ActErr err = new ActErr();

            err.setGameId(game.getId());
            err.setMatchId(game.getMatchId());
            err.setStreet(s);
            err.setAct(game.getAct(s));
            err.setOpt(game.getOpt(s));
            err.setType(type);

            actErrService.insert(err);
        }
    }
}
