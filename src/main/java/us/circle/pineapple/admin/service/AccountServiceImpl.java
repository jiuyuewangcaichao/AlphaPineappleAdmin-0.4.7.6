package us.circle.pineapple.admin.service;

import alpha.pineapple.ai.api.ErrResult;
import alpha.pineapple.ai.api.IAccountService;
import alpha.pineapple.ai.api.OKResult;
import alpha.pineapple.ai.api.Result;
import alpha.pineapple.ai.api.entity.UserAccount;
import com.alibaba.dubbo.config.annotation.Service;
import io.swagger.annotations.Api;
import org.hswebframework.web.entity.authorization.UserEntity;
import org.hswebframework.web.service.authorization.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.hswebframework.web.commons.entity.DataStatus;

@Service(interfaceClass = IAccountService.class)
@Component
@Api(tags = "",value="")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    UserService userService;

    @Override
    public Result<UserAccount> authenticate(String username, String plainPassword) {
        try {
            UserEntity entity = userService.selectByUserNameAndPassword(username, plainPassword);
            if (entity == null) {
                return new ErrResult("username or password invalid");
            }
            if (DataStatus.STATUS_DISABLED.equals(entity.getStatus())) {
                return new ErrResult("user is locked");
            }
            if (DataStatus.STATUS_LOCKED.equals(entity.getStatus())) {
                return new ErrResult("user is locked");
            }

            UserAccount acc = new UserAccount();
            acc.setName(entity.getName());
            acc.setUsername(username);
            acc.setUid(entity.getId());

            return new OKResult(acc);
        }
        catch (Exception e) {
            return new ErrResult(e.getMessage());
        }
    }
}
