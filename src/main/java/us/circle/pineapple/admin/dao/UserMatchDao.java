package us.circle.pineapple.admin.dao;

import org.hswebframework.web.dao.CrudDao;
import us.circle.pineapple.admin.api.UserMatch;

/**
*  
*  @author hsweb-generator3.0
 */
public interface UserMatchDao extends CrudDao<UserMatch,Long> {

    void clearCurMatch(String username);
}
