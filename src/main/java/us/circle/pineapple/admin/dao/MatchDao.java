package us.circle.pineapple.admin.dao;


import org.apache.ibatis.annotations.Param;
import org.hswebframework.web.dao.CrudDao;
import us.circle.pineapple.admin.api.Match;
import java.util.*;
/**
*  
*  @author hsweb-generator3.0
 */
public interface MatchDao extends CrudDao<Match,Long> {

        public Map<String,Object> showAvg(@Param("start_time")String start_time, @Param("finish_time") String finish_time, @Param("username")String username);

         public Object showMatch(int id);
 }
