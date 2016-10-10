package org.kin.live.live_account.service;

import org.kin.live.live_account.dao.GroupsMapper;
import org.kin.live.live_account.dao.UserMapper;
import org.kin.live.live_account.dao.custom.CustomMapper;
import org.kin.live.live_account.domain.Groups;
import org.kin.live.live_account.domain.GroupsExample;
import org.kin.live.live_account.domain.User;
import org.kin.live.live_account.domain.UserExample;
import org.kin.live.live_account.except.BaseException;
import org.kin.live.live_account.except.extend.GroupsException;
import org.kin.live.live_account.except.extend.UserException;
import org.kin.live.live_account.pojo.HisTrans;
import org.kin.live.live_account.pojo.PageTool;
import org.kin.live.live_account.pojo.SimpleUser;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public String queryGroupNameById(String groupId) throws BaseException{
        Groups groups = groupsMapper.selectByPrimaryKey(groupId);
        if(groups == null){
            throw BaseException.getException(GroupsException.class,GroupsException.ExceptCode.NoGroup.getMessage());
        }
        return groups.getName();
    }

    public List<User> getUserFromGroupName(String groupName) throws BaseException{
        GroupsExample example = new GroupsExample();
        GroupsExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(groupName);
        List<Groups> groupsList = groupsMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(groupsList)){
            throw BaseException.getException(GroupsException.class,GroupsException.ExceptCode.NoGroup.getMessage());
        }

        List<String> userIdList = new ArrayList<>();
        for(Groups groups : groupsList){
            userIdList.add(groups.getUserId());
        }

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria1 = userExample.createCriteria();
        criteria1.andIdIn(userIdList);
        List<User> userList = userMapper.selectByExample(userExample);
        if(CollectionUtils.isEmpty(userList)){
            throw BaseException.getException(UserException.class,UserException.ExceptCode.NoUser.getMessage());
        }

        return userList;
    }

    public User getUserById(String userId){
        return userMapper.selectByPrimaryKey(userId);
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
        if(groupId != null){
            simpleUserList = customMapper.selectSimpleUserByGroups(groupId);
        }
        return simpleUserList;
    }

    public BigDecimal totalPayAmt(String userId){
        return customMapper.getTotalAmt(userId);
    }

    public List<HisTrans> getTransOfOnePage(String userId, PageTool pageTool){
        Map map = new HashMap();
        map.put("userId",userId);
        map.put("startIndex",pageTool.getStartIndex());
        map.put("count",pageTool.getCount());

        Integer total = customMapper.hisTransCount(map);
        pageTool.setTotalCount(total);

        List<HisTrans> hisTransList = customMapper.hisTrans(map);
        if(CollectionUtils.isEmpty(hisTransList)){
            return new ArrayList<HisTrans>();
        }
        return hisTransList;
    }
}
