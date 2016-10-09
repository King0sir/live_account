package org.kin.live.live_account.service;

import org.kin.live.live_account.dao.GroupsMapper;
import org.kin.live.live_account.dao.UserMapper;
import org.kin.live.live_account.dao.custom.CustomMapper;
import org.kin.live.live_account.domain.Groups;
import org.kin.live.live_account.domain.GroupsExample;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.domain.UserExample;
import org.kin.live.live_account.except.BaseException;
import org.kin.live.live_account.pojo.SimpleUser;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingsir on 16-9-26.
 */
@Service
public class DomainService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private GroupsMapper groupsMapper;
    @Resource
    private CustomMapper customMapper;

    public Groups queryGroupsByUserId(String userId) throws BaseException {
        GroupsExample example = new GroupsExample();
        GroupsExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Groups> groupsList = groupsMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(groupsList)){
            return null;
        }
        return groupsList.get(0);
    }

    public User getUser(String user){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user.contains("@")){
            criteria.andEmailEqualTo(user);
        }else {
            try {
                Integer.parseInt(user);
                criteria.andPhoneEqualTo(user);
            }catch (Exception e){}
        }
        List<User> userList = userMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userList)){
            if(userList.size() == 1){
                return userList.get(0);
            }else {
                return null;
                //TODO:thr  exception
            }
        }
        return null;
    }

    public List<SimpleUser> getUserList(String groupId){
        List<SimpleUser> simpleUserList = new ArrayList<>();
        if(groupId == null){
            simpleUserList = customMapper.selectSimpleUserByGroups(groupId);
        }
        return simpleUserList;
    }

    public BigDecimal totalPayAmt(String userId){
        return customMapper.getTotalAmt(userId);
    }
}
