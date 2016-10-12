package org.kin.live.live_account.service;

import org.kin.live.live_account.dao.GroupsMapper;
import org.kin.live.live_account.dao.UserMapper;
import org.kin.live.live_account.domain.Groups;
import org.kin.live.live_account.domain.GroupsExample;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.except.BaseException;
import org.kin.live.live_account.except.extend.GroupsException;
import org.kin.live.live_account.except.extend.TransException;
import org.kin.live.live_account.except.extend.UserException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by kingsir on 16-9-25.
 */
@Service
public class ValidateService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private GroupsMapper groupsMapper;

    public void validateUserId(String userId) throws BaseException{
        User user = userMapper.selectByPrimaryKey(userId);
        if(user == null){
            BaseException.throwExcept(UserException.class,UserException.ExceptCode.NoUser.getMessage());
        }
        if(user.getEnable() == 0){
            BaseException.throwExcept(UserException.class,UserException.ExceptCode.NoEnableUser.getMessage());
        }
    }

    public void validateGroupName(String groupName) throws BaseException{
        GroupsExample example = new GroupsExample();
        GroupsExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(groupName);
        List<Groups> groupsList = groupsMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(groupsList)){
            return;
        }
        throw BaseException.getException(GroupsException.class,GroupsException.ExceptCode.ExistGroupName.getMessage());
    }

    public void validateJoinGroupName(String groupName) throws BaseException{
        GroupsExample example = new GroupsExample();
        GroupsExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(groupName);
        List<Groups> groupsList = groupsMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(groupsList)){
            return;
        }
        throw BaseException.getException(GroupsException.class,GroupsException.ExceptCode.NoGroup.getMessage());
    }

    public void transParamsValidate(HttpServletRequest request) throws TransException {
        String payTime = request.getParameter("payTime");
        String transAmt = request.getParameter("transAmt");
        String payerId = request.getParameter("payer");
        String shares = request.getParameter("shares");
        String memo = request.getParameter("memo");
        if(StringUtils.isEmpty(payTime)){
            throw BaseException.getException(TransException.class,TransException.ExceptCode.NoLegalPayTime.getMessage());
        }
        if(StringUtils.isEmpty(transAmt)){
            throw BaseException.getException(TransException.class,TransException.ExceptCode.NoLegalTransAmt.getMessage());
        }
        if(StringUtils.isEmpty(payerId)){
            throw BaseException.getException(TransException.class,TransException.ExceptCode.NoLegalPayerId.getMessage());
        }
        if(StringUtils.isEmpty(shares)){
            throw BaseException.getException(TransException.class,TransException.ExceptCode.NoLegalShares.getMessage());
        }
    }
}
