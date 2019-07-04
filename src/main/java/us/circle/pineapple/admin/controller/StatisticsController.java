package us.circle.pineapple.admin.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.circle.pineapple.admin.api.StatisticsService;
import us.circle.pineapple.admin.dao.MatchDao;

import java.util.*;

import java.util.HashMap;
import java.util.List;


/**
 * Created by circleus on 2019/7/2.
 */
@RestController
@RequestMapping("/statistics")

public class StatisticsController {

   @Autowired
   private StatisticsService statisticsService;

   @RequestMapping("/showAvg")
   public Map<String,Object> showAvg(String start_time, String finish_time, String username){
      Map<String,Object>result =statisticsService.showAvg(start_time, finish_time, username);
      return  result;
   };

}
