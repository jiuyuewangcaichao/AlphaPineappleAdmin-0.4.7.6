package us.circle.pineapple.admin.api;

import org.apache.ibatis.annotations.Param;

import java.util.*;

/**
 * Created by circleus on 2019/7/2.
 */
public interface StatisticsService {
    public Map<String,Object> showAvg(@Param("start_time") String start_time, @Param("finish_time")String finish_time, @Param("username")String username);
}
