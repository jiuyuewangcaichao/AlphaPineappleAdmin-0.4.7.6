package us.circle.pineapple.admin.service;

import com.alibaba.dubbo.config.annotation.Service;
import groovy.transform.ASTTest;
import org.springframework.beans.factory.annotation.Autowired;
import us.circle.pineapple.admin.api.StatisticsService;
import us.circle.pineapple.admin.dao.MatchDao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by circleus on 2019/7/2.
 */
@Service
public class StatisticsServiceimpl implements StatisticsService{

    @Autowired
    private MatchDao dao;

    @Override
    public Map<String, Object> showAvg(String start_time, String finish_time, String username) {
//        Map<String, Object> result1 = dao.showAvg(start_time,finish_time,username);

        Map<String,Object> result= new HashMap<>();
        List<String> datetime = new ArrayList<String>();
        List<Integer> k3_avg_score = new ArrayList<Integer>();
        List<Integer> ace_avg_score= new ArrayList<Integer>();
        List<Integer> King_avg_score = new ArrayList<Integer>();
        List<Integer> queen_avg_score = new ArrayList<Integer>();
        datetime.add("2019-10-11");
        k3_avg_score.add(1);
        King_avg_score.add(2);
        ace_avg_score.add(1);
        queen_avg_score.add(2);
        result.put("datetime",datetime);
        result.put("k3_avg_score",k3_avg_score);
        result.put("ace_avg_score",ace_avg_score);
        result.put("King_avg_score",King_avg_score);
        result.put("queen_avg_score",queen_avg_score);
        return result;
    }


}
