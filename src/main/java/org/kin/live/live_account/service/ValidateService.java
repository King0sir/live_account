package org.kin.live.live_account.service;

import org.kin.live.live_account.dao.UserMapper;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.except.BaseException;
import org.kin.live.live_account.except.extend.UserException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by kingsir on 16-9-25.
 */
@Service
public class ValidateService {

    @Resource
    private UserMapper userMapper;

    public void validateUserId(String userId) throws BaseException{
        User user = userMapper.selectByPrimaryKey(userId);
        if(user == null){
            BaseException.throwExcept(UserException.class,UserException.ExceptCode.NoUser.getMessage());
        }
        if(user.getEnable() == 0){
            BaseException.throwExcept(UserException.class,UserException.ExceptCode.NoEnableUser.getMessage());
        }
    }

    public void transParamsValidate(HttpServletRequest request){
        String payTime = request.getParameter("payTime");
        String transAmt = request.getParameter("transAmt");
        String payerId = request.getParameter("payer");
        String shares = request.getParameter("shares");
        String memo = request.getParameter("memo");
        if(StringUtils.isEmpty(payTime)){
//            throw new BaseException();
        }
    }
}
